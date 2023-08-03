package com.ppl.jpa.service.impl;


import com.ppl.jpa.entity.db.Student;
import com.ppl.jpa.entity.query.StudentPage;
import com.ppl.jpa.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 下面注解的作用
 *SpringBootTest：这个注解用于启动整个 Spring Boot 应用程序上下文，以便在测试中可以访问完整的 Spring 环境。
 * 它会加载所有的配置、组件和依赖，类似于实际应用的运行环境。在测试类上添加 @SpringBootTest 注解时，
 * 可以通过依赖注入等方式使用应用中的组件。
 *RunWith(SpringRunner.class)：这个注解指定了测试运行器，用于在测试框架中执行测试。
 * 对于 Spring Boot 项目，使用 SpringRunner 来执行测试是常见的做法。
 *Transactional：这个注解用于在测试方法上创建一个事务，并在测试方法执行完成后回滚事务。
 * 它确保了测试方法在一个事务中执行，这对于数据库操作测试非常有用。使用 @Transactional 可以保持数据库状态的干净，避免测试之间相互影响。
 *Rollback：这个注解用于控制测试方法是否在执行后回滚事务。默认情况下，@Rollback 的值为 true，表示在测试方法执行后回滚事务，恢复数据库状态。
 * 如果你将 @Rollback 的值设置为 false，则测试方法执行后不会回滚事务，可能会影响数据库状态。
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
@Rollback
public class StudentServiceImplTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void findAll() {
        List<Student> list = studentService.findAll();
        System.out.println(list);
    }

    @Test
    public void findById() {
        Student student = studentService.findById(1);
        System.out.println(student);
    }

    @Test
    public void page(){
        StudentPage pageQuery = new StudentPage();
        pageQuery.setPage(1);
        pageQuery.setSize(10);
        pageQuery.setMinAge(0);
        pageQuery.setMaxAge(100);
        pageQuery.setName("张三");
        Page<Student> page = studentService.page(pageQuery);

        System.out.println("page = " + page);
    }
}