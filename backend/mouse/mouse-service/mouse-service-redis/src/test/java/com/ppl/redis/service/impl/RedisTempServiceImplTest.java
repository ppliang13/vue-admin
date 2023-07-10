package com.ppl.redis.service.impl;


import com.ppl.redis.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by pisiliang on 2023/7/10 15:05
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTempServiceImplTest {

    @Autowired
    private RedisTempServiceImpl redisTempService;

    @Autowired
    private StudentServiceImpl studentService;

    @Test
    public void testSaveStudent() {
        List<Student> randomStudent = studentService.getRandomStudent(10);
        List<Student> students = redisTempService.saveStudent(randomStudent);
        System.out.println("students = " + students);
    }
}