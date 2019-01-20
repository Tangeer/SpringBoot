package com.longrise.springboot.controller;

import com.longrise.springboot.module.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:RestFullController
 * Package:com.longrise.springboot.controller
 * Description:
 *
 * @Date:2018/12/16 10:44
 * @Author:Tanger@longrise.com
 */
@RestController
public class RestFullController {

//    http://localhost:8080/boot/user/3
    @RequestMapping("/boot/user/{id}")
    public Object user(@PathVariable("id") Integer id){

        User user = new User();
        user.setId(3);
        user.setName("张三丰");
        return user;

    }

    //    http://localhost:8080/boot/user/3/zhangsan
    @RequestMapping("/boot/user/{id}/{name}")
    public Object user(@PathVariable("id") Integer id,@PathVariable("name") String name){

        User user = new User();
        user.setId(3);
        user.setName(name);
        return user;

    }
}
