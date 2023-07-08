package com.ppl.thread.service.impl;

import com.ppl.thread.pojo.People;
import com.ppl.thread.pojo.Student;
import com.ppl.thread.service.ParallelStreamService;
import com.ppl.thread.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pisiliang on 2023/7/8 19:48
 */
@Service
public class ParallelStreamServiceImpl implements ParallelStreamService {

    @Autowired
    private PeopleService peopleService;


    @Override
    public int parallelStream(int count) {
        ArrayList<Student> list = new ArrayList<>(count);

        List<People> peopleList = peopleService.getPeopleList(count);

        peopleList.parallelStream().forEach(people -> {
            sleep();
            Student student = new Student();
            student.setName(people.getName());
            student.setAge(people.getAge());
            list.add(student);
        });

        System.out.println("list = " + list);

        return list.size();
    }


    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
