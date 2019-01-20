package com.longrise.springboot.controller;

import com.longrise.springboot.model.Student;
import com.longrise.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName:MyBatisController
 * Package:com.longrise.springboot.controller
 * Description:
 *
 * @Date:2018/12/15 17:54
 * @Author:Tanger@longrise.com
 */
@RestController
public class MyBatisController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/boot/Student")
    public List<Student> getAllStudent(){
        return studentService.selectAllStudent();
    }

    @GetMapping("/boot/update")
    public int update(){
        return studentService.update();
    }
}
