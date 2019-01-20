package com.longrise.springboot.service;

import com.longrise.springboot.model.Student;

/**
 * ClassName:StudentService
 * Package:com.longrise.springboot.service
 * Description:
 *
 * @Date:2018/12/17 21:28
 * @Author:Tanger@longrise.com
 */
public interface StudentService {

    public String sayHi(String name);

    public Student getStudent(Integer id);
}
