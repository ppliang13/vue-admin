package com.ppl.redis.service.impl;

import com.ppl.redis.pojo.Student;
import com.ppl.redis.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pisiliang on 2023/7/10 14:59
 */
@Service
public class StudentServiceImpl implements StudentService {


    @Override
    public List<Student> getRandomStudent(int size) {
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Student student = new Student();
            student.setId(String.valueOf(i));
            student.setName("name" + i);
            student.setAge(String.valueOf(i));
            list.add(student);
        }
        return list;
    }
}
