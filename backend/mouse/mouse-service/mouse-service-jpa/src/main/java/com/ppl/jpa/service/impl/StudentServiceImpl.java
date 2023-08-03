package com.ppl.jpa.service.impl;

import com.ppl.jpa.dao.StudentDao;
import com.ppl.jpa.entity.db.Student;
import com.ppl.jpa.entity.query.StudentPage;
import com.ppl.jpa.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by pisiliang on 2023/8/2 15:25
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;


    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return studentDao.getById(id);
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public void  deleteById(Integer id) {
        studentDao.deleteById(id);
    }

    @Override
    public Page<Student> page(StudentPage page) {
        return null;
    }


}
