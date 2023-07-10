package com.ppl.thread.service.impl;

import com.ppl.thread.service.ThreadListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.function.Function;

/**
 * Created by pisiliang on 2023/7/7 10:03
 */
@Service
public class ThreadListServiceImpl implements ThreadListService {


    @Autowired
    @Qualifier("asyncExecutor2")//指定线程池
    private ThreadPoolTaskExecutor executor;


    @Override
    public List threadList(List source, Function transfer) {
        if (source==null) {
            return null;
        }
        ArrayList<Object> target = new ArrayList<>(source.size());
        if (source.size()==0) {
            return target;
        }
        for (int i = 0; i < source.size(); i++) {
            target.add(new Object());
        }

        ArrayList<Future> futures = new ArrayList<>();
        for (int i = 0; i < source.size(); i++) {
            int finalI = i;
            Future future = executor.submit(() -> {
                target.set(finalI,transfer.apply(source.get(finalI)));
            });
            futures.add(future);
        }

        /**
         * 等待执行结束
         */
        for (Future future : futures) {
            try {
                future.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return target;
    }
}
