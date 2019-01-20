package com.longrise.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.longrise.springboot.mapper.UserMapper;
import com.longrise.springboot.model.User;
import com.longrise.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * ClassName:UserServiceImpl
 * Package:com.longrise.springboot.service.impl
 * Description:
 *
 * @Date:2019/1/12 10:41
 * @Author:Tanger@longrise.com
 */

@Component
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<User> getUserByPage(Map<String, Object> parMap) {

        return userMapper.selectUserByPage(parMap);
    }

    @Override
    public int getUserByTotal() {
        //字符串的序列化器
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);

        //高并发条件下，此处有点问题：缓存穿透
        //查询缓存
        Integer userByTotal = (Integer) redisTemplate.opsForValue().get("userByTotal");
        //双重检测锁
        if(null == userByTotal){
            synchronized (this){
                //从redis里获取一下
                userByTotal = (Integer)redisTemplate.opsForValue().get("userByTotal");
                if(null == userByTotal){
                    //缓存为空，查询一遍数据库
                    userByTotal = userMapper.selectUserByTotal();
                    //把数据库查询出来的数据放入redis中
                    redisTemplate.opsForValue().set("userByTotal",userByTotal);
                }

            }
        }

        return userByTotal;
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteUserById(Integer id) {
        int delete = userMapper.deleteByPrimaryKey(id);
        if (delete > 0) {
            //更新缓存
            Integer userByTotal = userMapper.selectUserByTotal();
            //把数据库查询出来的数据，放入redis中
            redisTemplate.opsForValue().set("userByTotal", userByTotal);
        }
        return delete;
    }

    @Override
    public int addUser(User user) {
        int add = userMapper.insertSelective(user);
        if (add > 0) {
            //更新缓存
            Integer userByTotal = userMapper.selectUserByTotal();
            //把数据库查询出来的数据，放入redis中
            redisTemplate.opsForValue().set("userByTotal", userByTotal);
        }
        return add;
    }
}
