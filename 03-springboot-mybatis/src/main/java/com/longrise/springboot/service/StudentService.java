package com.longrise.springboot.service;

import com.longrise.springboot.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:StudentService
 * Package:com.longrise.springboot.service
 * Description:
 *
 * @Date:2018/12/15 17:41
 * @Author:Tanger@longrise.com
 */


public interface StudentService {

    List<Student> selectAllStudent();

}
