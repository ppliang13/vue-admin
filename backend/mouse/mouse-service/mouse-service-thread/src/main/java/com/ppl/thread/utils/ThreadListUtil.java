package com.ppl.thread.utils;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * Created by pisiliang on 2023/7/7 9:55
 */
public class ThreadListUtil<T1,T2> {

    public void threadList(List<T1> list1, List<T2> list2, BiConsumer<T1, T2> function){
        if (list1==null&&list2==null) {
            return;
        }
        if (list1.size()==0&&list2.size()==0) {
            return;
        }
        for (int i = 0; i < list1.size(); i++) {
            T1 t1 = list1.get(i);
            T2 t2 = list2.get(i);

            function.accept(t1,t2);
        }
    }
}
