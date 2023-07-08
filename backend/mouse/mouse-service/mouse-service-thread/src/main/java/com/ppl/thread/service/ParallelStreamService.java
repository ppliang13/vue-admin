package com.ppl.thread.service;

/**
 * parallel Stream
 * Created by pisiliang on 2023/7/8 19:46
 */
public interface ParallelStreamService {

    /**
     * 使用parallelStream 实现线程处理数据 但是不保证数据的顺序
     * @param count 数据量
     * @return 处理后的数据量
     */
    int parallelStream(int count);
}
