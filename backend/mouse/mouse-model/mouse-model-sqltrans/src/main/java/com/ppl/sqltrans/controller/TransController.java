package com.ppl.sqltrans.controller;

import com.ppl.sqltrans.service.TransToSqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pisiliang on 2023/6/30 10:36
 */
@RestController
public class TransController {

    @Autowired
    private TransToSqlService transService;

    @GetMapping("/transToSql")
    public String transToSql() {
        return "hello";
    }


    @GetMapping("/hello")
    public String hello() {
        return transService.toSql2();
    }
}
