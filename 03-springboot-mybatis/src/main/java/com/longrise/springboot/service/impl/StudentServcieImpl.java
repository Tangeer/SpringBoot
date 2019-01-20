package com.longrise.springboot.service.impl;

import com.longrise.springboot.mapper.StudentMapper;
import com.longrise.springboot.model.Student;
import com.longrise.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:StudentServcieImpl
 * Package:com.longrise.springboot.service.impl
 * Description:
 *
 * @Date:2018/12/15 17:47
 * @Author:Tanger@longrise.com
 */

@Service
public class StudentServcieImpl implements StudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

//    @Override
//    public List<Student> selectAllStudent() {
//        //字符串的序列化器
//        RedisSerializer redisSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(redisSerializer);
//        //高并发条件下，此处有问题：缓存穿透问题
//        //先去缓存中去下
//        List<Student> studentList = (List<Student>) redisTemplate.opsForValue().get("allStudents");
//        if(null == studentList){
//            System.out.println("走数据库。。。。。。。。。");
//            //查数据库
//            studentList = studentMapper.selectAllStudent();
//            redisTemplate.opsForValue().set("allStudents",studentList);
//
//        }else{
//            System.out.println("走的缓存。。。。。。。。。。");
//        }
//        return studentList;
//    }

    @Override
    public List<Student> selectAllStudent() {
        //字符串的序列化器
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        //高并发条件下，此处有问题：缓存穿透问题
        //先去缓存中去下
        List<Student> studentList = (List<Student>) redisTemplate.opsForValue().get("allStudents");
        //双重检测锁
        if(null == studentList){
            synchronized (this){
                studentList = (List<Student>) redisTemplate.opsForValue().get("allStudents");
                if(null == studentList){
                    //查数据库
                    System.out.println("走的数据库。。。。。。");
                    studentList = studentMapper.selectAllStudent();
                    redisTemplate.opsForValue().set("allStudents",studentList);

                }else{
                    System.out.println("走的缓存。。。。。。");
                }

            }

        }else{
            System.out.println("走的缓存。。。。。。。。。");
        }

        return studentList;
    }
}
