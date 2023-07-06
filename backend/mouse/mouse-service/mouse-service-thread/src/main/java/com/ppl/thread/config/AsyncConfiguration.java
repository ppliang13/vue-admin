package com.ppl.thread.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncConfiguration {

    @Bean("asyncExecutor")
    public ThreadPoolTaskExecutor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10); // 设置核心线程数
        executor.setMaxPoolSize(20); // 设置最大线程数
        executor.setQueueCapacity(200); // 设置队列大小
        executor.setThreadNamePrefix("MyAsyncExecutor-"); // 设置线程名前缀 
        executor.initialize();
        return executor;
    }

    @Bean("asyncExecutor2")
    public ThreadPoolTaskExecutor asyncExecutor2() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10); // 设置核心线程数
        executor.setMaxPoolSize(20); // 设置最大线程数
        executor.setQueueCapacity(200); // 设置队列大小
        executor.setThreadNamePrefix("MyAsyncExecutor-"); // 设置线程名前缀
        executor.initialize();
        return executor;
    }
}
