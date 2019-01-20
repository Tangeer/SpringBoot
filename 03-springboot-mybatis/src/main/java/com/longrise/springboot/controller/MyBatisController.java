package com.longrise.springboot.controller;

import com.longrise.springboot.model.Student;
import com.longrise.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    @GetMapping("/boot/getAllStudent")
    public List<Student> getAllStudent() {
        return studentService.selectAllStudent();
    }

    //多线程测试缓存穿透
    @GetMapping("/boot/getStudents")
    public Object getStudents() {
        //线程，该线程调用底层查询所有学生的方法
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                studentService.selectAllStudent();
            }
        };
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(25);
        for (int i=0; i<1000; i++){
            executorService.submit(runnable);
        }

        return studentService.selectAllStudent();
    }

}
