package com.ppl.redis.service.impl;

import com.ppl.redis.pojo.Student;
import com.ppl.redis.service.RedisTempService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * redis 使用案例
 * Created by pisiliang on 2023/7/10 14:56
 */
@Service
public class RedisTempServiceImpl implements RedisTempService {

    @Resource
    private RedisTemplate<String, Student> redisTemplate;

    private final String REDIS_KEY = "student:";

    public List<Student> saveStudent(List<Student> list) {
        for (Student student : list) {
            redisTemplate.opsForValue().set(REDIS_KEY + student.getId(), student);
        }
        return list;
    }


}
