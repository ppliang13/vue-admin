package com.ppl.jpa.service;

import com.ppl.jpa.entity.db.Student;
import com.ppl.jpa.entity.query.StudentPage;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by pisiliang on 2023/8/2 15:24
 */
public interface StudentService {

    List<Student> findAll();

    Student findById(Integer id);

    Student save(Student student);

    void deleteById(Integer id);

    Page<Student> page(StudentPage page);
}
