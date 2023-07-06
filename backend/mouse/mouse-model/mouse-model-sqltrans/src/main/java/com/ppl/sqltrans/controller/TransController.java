package com.ppl.sqltrans.controller;

import com.ppl.sqltrans.pojo.ps.MyPlainSelect;
import com.ppl.sqltrans.service.TransToSqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String hello(@RequestParam Integer size) throws InterruptedException {
        return transService.testAsync(size);
    }


    @GetMapping("/toSql")
    public String toSql(@RequestBody MyPlainSelect plainSelect) {

        return transService.toSql(plainSelect);
    }
}
