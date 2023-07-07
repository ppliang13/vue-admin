package com.ppl.thread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by pisiliang on 2023/7/7 8:59
 */
@SpringBootApplication
@EnableAsync
public class ThreadStart {

    public static void main(String[] args) {
        SpringApplication.run(ThreadStart.class, args);
    }

}
