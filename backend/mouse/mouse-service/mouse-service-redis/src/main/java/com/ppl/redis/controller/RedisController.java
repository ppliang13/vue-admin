package com.ppl.redis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pisiliang on 2023/7/10 15:11
 */
@RestController
public class RedisController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
