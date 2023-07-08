package com.ppl.thread.service.impl;

import com.ppl.thread.service.AsyncService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by pisiliang on 2023/7/8 19:54
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class ParallelStreamServiceImplTest {

    @Resource
    private ParallelStreamServiceImpl parallelStreamService;
    @Resource
    private AsyncService asyncService;

    @Test
    void parallelStream() {
        long begin = System.currentTimeMillis();
        int i = parallelStreamService.parallelStream(10);
        long end = System.currentTimeMillis();


        long begin1 = System.currentTimeMillis();
        asyncService.testThreadList(10);
        long end1 = System.currentTimeMillis();
        System.out.println("耗时 = " + (end1 - begin1) + "ms");
        System.out.println("耗时 = " + (end - begin) + "ms");
    }
}