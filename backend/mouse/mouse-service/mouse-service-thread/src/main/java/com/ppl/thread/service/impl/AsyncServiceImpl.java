package com.ppl.thread.service.impl;

import com.ppl.thread.pojo.People;
import com.ppl.thread.pojo.Student;
import com.ppl.thread.service.AsyncService;
import com.ppl.thread.service.ThreadListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by pisiliang on 2023/7/6 17:23
 */
@Service
public class AsyncServiceImpl implements AsyncService {

    @Autowired
    @Qualifier("asyncExecutor2")
    private ThreadPoolTaskExecutor executor;

    @Override
    @Async("asyncExecutor")
    public void async() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("异步线程执行完毕");
    }




    @Override
    public void future(int size){
        ArrayList<Future> futures = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int finalI = i;
            Future future = executor.submit(() -> {
                try {
                    Thread.sleep(2000L);
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(finalI +"异步线程执行完毕");
            });
            futures.add(future);
        }

        for (Future future : futures) {
            try {
                future.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }


    @Autowired
    private ThreadListService<People,Student> threadListService;

    public void testThreadList() {
        ArrayList<People> peoples = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            People people = new People();
            people.setName("name"+i);
            people.setAge(i+"");
            peoples.add(people);
        }


        List<Student> students = threadListService.threadList(peoples, (people) -> {
            Student student = new Student();
            student.setName(people.getName());
            student.setAge(people.getAge());
            return student;
        });

        for (Student student : students) {
            System.out.println("student = " + student);
        }

    }

}
