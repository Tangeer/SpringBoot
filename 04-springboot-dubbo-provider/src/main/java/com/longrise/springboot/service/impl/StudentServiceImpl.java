package com.longrise.springboot.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.longrise.springboot.mapper.StudentMapper;
import com.longrise.springboot.model.Student;
import com.longrise.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName:StudentServiceImpl
 * Package:com.longrise.springboot.service.impl
 * Description:
 *
 * @Date:2018/12/17 21:31
 * @Author:Tanger@longrise.com
 */
@Component
@Service(version = "0.0.1-SNAPSHOT",timeout = 10000)
//dubbo注解<dubbo:service interface="" ref="" version=""/>
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public String sayHi(String name) {
        return "Hi SpringBoot"+name;
    }

    @Override
    public Student getStudent(Integer id) {
        //查数据库
        return studentMapper.selectByPrimaryKey(id);
    }
}
