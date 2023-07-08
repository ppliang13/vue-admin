package com.ppl.thread.service.impl;

import com.ppl.thread.pojo.People;
import com.ppl.thread.service.PeopleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pisiliang on 2023/7/8 19:49
 */
@Service
public class PeopleServiceImpl implements PeopleService {


    @Override
    public List<People> getPeopleList(int count) {
        ArrayList<People> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            People people = new People();
            people.setName("name" + i);
            people.setAge(i+"岁");
            list.add(people);
        }
        return list;
    }
}
