package com.ppl.thread.service;

import com.ppl.thread.pojo.People;

import java.util.List;

/**
 * Created by pisiliang on 2023/7/8 19:50
 */
public interface PeopleService {

    List<People> getPeopleList(int count);
}
