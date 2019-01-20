package com.longrise.springboot.controller;

import com.longrise.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * ClassName:ThymeleafController
 * Package:com.longrise.springboot.controller
 * Description:
 *
 * @Date:2019/1/4 21:46
 * @Author:Tanger@longrise.com
 */
@Controller
public class ThymeleafController {

    @RequestMapping("/boot/index")
    public String index(Model model, HttpServletRequest request) {
        model.addAttribute("msg", "springboot 集成 thymeleaf");
//对象
        User user = new User();
        user.setId(1);
        user.setNick("Tanger");
        user.setPhone("13700020000");
        user.setAddress("北京大兴");
        user.setEmail("12343254@qq.com");
        model.addAttribute("user", user);
        model.addAttribute("hello", "helloworld");
//ArrayList集合
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user1 = new User();
            user1.setId(i);
            user1.setNick("昵称" + i);
            user1.setPhone("13700020000");
            user1.setAddress("北京大兴" + i);
            user1.setEmail("12343254@qq.com");
            list.add(user1);
        }
        model.addAttribute("list", list);

 //ArrayList集合
        Map<String,Object> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            User user2 = new User();
            user2.setId(i);
            user2.setNick("昵称" + i);
            user2.setPhone("13700020000");
            user2.setAddress("北京大兴" + i);
            user2.setEmail("12343254@qq.com");
            map.put(String.valueOf(i),user2);
        }
        model.addAttribute("map",map);

        model.addAttribute("sex","1");

        model.addAttribute("curDate",new Date());

        model.addAttribute("str","dsafjkoldasjtfgioweutiowe");

        request.setAttribute("name","www.longrsie.com");
        request.getSession().setAttribute("address","shenzheng");



        return "index";
    }
}
