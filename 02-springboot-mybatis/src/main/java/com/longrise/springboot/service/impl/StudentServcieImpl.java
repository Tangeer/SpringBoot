package com.longrise.springboot.service.impl;

import com.longrise.springboot.mapper.StudentMapper;
import com.longrise.springboot.model.Student;
import com.longrise.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName:StudentServcieImpl
 * Package:com.longrise.springboot.service.impl
 * Description:
 *
 * @Date:2018/12/15 17:47
 * @Author:Tanger@longrise.com
 */

@Service
public class StudentServcieImpl implements StudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectAllStudent() {

        return studentMapper.selectAllStudent();
    }

    @Transactional
    @Override
    public int update(){
        Student student = new Student();
        student.setId(2);
        student.setStuname("Tanger_update");
        student.setStusex("男");
        int up = studentMapper.updateByPrimaryKey(student);
        System.out.println("更新后的结果"+up);

//      会抛出一个运行时异常,导致更新操作会回滚
        int a = 10/0;

        return up;
    }
}
