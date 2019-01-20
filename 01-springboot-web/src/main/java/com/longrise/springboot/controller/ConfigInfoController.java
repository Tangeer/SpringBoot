package com.longrise.springboot.controller;

import com.longrise.springboot.config.ConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName:ConfigInfoController
 * Package:com.longrise.springboot.controller
 * Description:
 *
 * @Date:2018/12/10 22:25
 * @Author:Tanger@longrise.com
 */
@Controller
public class ConfigInfoController {

//    @Value("${boot.name}")
//    private String name;
//
//    @Value("${boot.location}")
//    private String location;

    @Autowired
    private ConfigInfo configInfo;

    @RequestMapping("/boot/config")
    public @ResponseBody String config(){
//        return name+"----"+location;
        return configInfo.getName()+"-----------"+configInfo.getLocation();
    }
}
