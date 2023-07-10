package com.ppl.redis.service;

import com.ppl.redis.pojo.Student;

import java.util.List;

/**
 * Created by pisiliang on 2023/7/10 14:59
 */
public interface StudentService {

    List<Student> getRandomStudent(int size);
}
