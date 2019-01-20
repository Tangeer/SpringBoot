package com.longrise.springboot.controller;

import com.longrise.springboot.module.User;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:MVCController
 * Package:com.longrise.springboot.controller
 * Description:
 *
 * @Date:2018/12/11 21:39
 * @Author:Tanger@longrise.com
 */
@RestController //@RestController=@Controller + @Responsebody
public class MVCController {
    @RequestMapping(value = "/boot/getUser",method = RequestMethod.GET)
//    @RequestMapping("/boot/getUser")
    public Object getUser() {
        User user = new User();
        user.setId(100);
        user.setName("张无忌");
        return user;
    }

    /**
     * @GetMapping 只支持get请求 @GetMapping=@@RequestMapping + RequestMethod.GET
     * @return
     */
    @GetMapping("/boot/getUser1")
    public Object getUser1() {
        User user = new User();
        user.setId(100);
        user.setName("张无忌");
        return user;
    }

    /**
     * @PostMapping 浏览器无法请求到，浏览器请求是get
     * @return
     */
    @PostMapping ("/boot/getUser2")
    public Object getUser2() {
        User user = new User();
        user.setId(100);
        user.setName("张无忌");
        return user;
    }


}
