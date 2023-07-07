package com.ppl.thread.service;

/**
 * Created by pisiliang on 2023/7/6 17:23
 */
public interface AsyncService {

    /**
     * 异步线程
     */
    void async();


    void future(int size);

    void testThreadList();
}

