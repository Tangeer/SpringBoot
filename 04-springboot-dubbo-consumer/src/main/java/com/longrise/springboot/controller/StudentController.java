package com.longrise.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.longrise.springboot.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:StudentController
 * Package:com.longrise.springboot.controller
 * Description:
 *
 * @Date:2018/12/18 22:13
 * @Author:Tanger@longrise.com
 */

@RestController
public class StudentController {

    @Reference(version = "0.0.1-SNAPSHOT")
    private StudentService studentService;

    @RequestMapping("/boot/getStudent")
    public Object getStudent(@RequestParam("id") Integer id){
        return studentService.getStudent(id);

    }

    @RequestMapping("/boot/sayHi")
    public Object sayHi(){
        return studentService.sayHi("dubbo");

    }
}
