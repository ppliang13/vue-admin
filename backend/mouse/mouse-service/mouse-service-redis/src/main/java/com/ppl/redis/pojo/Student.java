package com.ppl.redis.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by pisiliang on 2023/7/7 10:13
 */
@Data
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String age;
}
