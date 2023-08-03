package com.ppl.jpa.dao;

import com.ppl.jpa.entity.db.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pisiliang on 2023/8/2 15:22
 */
public interface StudentDao extends JpaRepository<Student, Integer> {

}
