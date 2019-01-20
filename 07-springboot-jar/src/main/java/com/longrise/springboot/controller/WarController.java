package com.longrise.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:WarController
 * Package:com.longrise.springboot.controller
 * Description:
 *
 * @Date:2019/1/1 12:19
 * @Author:Tanger@longrise.com
 */
@Controller
public class WarController {
    @ResponseBody
    @RequestMapping("/boot/json")
    public Object json(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","永兴元科技");
        map.put("address","永兴元科技");
        return map;
    }

    @RequestMapping("/boot/jsp")
    public String jsp(Model model){
        model.addAttribute("name","永兴元科技");
        return "index";
    }


}
