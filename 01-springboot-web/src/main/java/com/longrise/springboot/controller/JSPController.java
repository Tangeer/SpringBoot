package com.longrise.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName:JSPController
 * Package:com.longrise.springboot.controller
 * Description:
 *
 * @Date:2018/12/11 22:22
 * @Author:Tanger@longrise.com
 */
@Controller
public class JSPController {

    @GetMapping("/boot/index")
    public String index(Model model){
        model.addAttribute("msg","springboot 集成 jsp.");
        return "index";
    }

}
