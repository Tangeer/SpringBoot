package com.longrise.springboot.service;

import com.longrise.springboot.model.User;

import java.util.List;
import java.util.Map;

/**
 * ClassName:UserService
 * Package:com.longrise.springboot.service
 * Description:
 *
 * @Date:2019/1/12 8:55
 * @Author:Tanger@longrise.com
 */
public interface UserService {

    /**
     * 分页的查询
     * @param parMap
     * @return
     */
    public List<User> getUserByPage(Map<String, Object> parMap);

    /**
     * 分页的总数
     * @return
     */
    public int getUserByTotal();

    /**
     * 根据用户ID查询用户信息
     * @param id
     * @return
     */
    public User getUserById(Integer id);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 根据用户ID删除用户
     * @param id
     * @return
     */
    public int deleteUserById(Integer id);

    /**
     * 添加用户
     * @param user
     * @return
     */
    public int addUser(User user);
}