package com.ppl.thread.service;

import java.util.List;
import java.util.function.Function;

/**
 * Created by pisiliang on 2023/7/7 9:31
 */
public interface ThreadListService<T1,T2> {

    /**
     * 多线程处理list的数据 由于list中的数据可能需要转化 转化需要时间
     * 将转换方法线程执行提高转换的效率
     * @param source 源数据
     * @param transfer 转化方法
     * @return 转化后的数据
     */
     List<T2> threadList(List<T1> source, Function<T1,T2> transfer);

}
