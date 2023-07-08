package com.ppl.thread.service.impl;




import com.ppl.thread.service.AsyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by pisiliang on 2023/7/7 9:01
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class AsyncServiceImplTest  {

    @Resource
    private AsyncService asyncService;



    @Test
    public void testAsync() throws InterruptedException {
        asyncService.async();
        System.out.println("asyncService异步线程执行");
        Thread.sleep(3000L);

    }

    @Test
    public void testFuture() {
        asyncService.future(100);
        System.out.println("asyncService异步线程执行");
    }

    @Test
    public void testThreadList() {
        asyncService.testThreadList(10);
        System.out.println("asyncService异步线程执行");
    }


}