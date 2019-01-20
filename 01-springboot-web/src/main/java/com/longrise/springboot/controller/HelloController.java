package com.longrise.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName:HelloController
 * Package:com.longrise.springboot.controller
 * Description:
 *
 * @Date:2018/12/10 21:27
 * @Author:Tanger@longrise.com
 */

@Controller
public class HelloController {
    @RequestMapping("/boot/hello")
    public @ResponseBody String hello(){
        return "hello spring boot.";
    }

}
