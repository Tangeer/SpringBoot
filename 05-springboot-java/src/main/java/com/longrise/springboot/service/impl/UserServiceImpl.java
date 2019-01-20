package com.longrise.springboot.service.impl;

import com.longrise.springboot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * ClassName:UserServiceImpl
 * Package:com.longrise.springboot.service.impl
 * Description:
 *
 * @Date:2018/12/22 11:30
 * @Author:Tanger@longrise.com
 */

@Service
public class UserServiceImpl implements UserService{

    @Override
    public String getUser(String name) {
        return "Hi," + name;
    }
}
