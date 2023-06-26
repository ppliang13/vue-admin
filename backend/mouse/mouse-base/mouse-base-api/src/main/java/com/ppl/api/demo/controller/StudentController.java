package com.ppl.api.demo.controller;

import com.ppl.api.demo.pojo.model.req.StudentReq;
import com.ppl.api.demo.pojo.model.vo.StudentVo;
import com.ppl.api.demo.service.StudentService;
import com.ppl.common.controller.BaseController;
import com.ppl.common.pojo.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by pisiliang on 2023/6/25 11:14
 */
@RestController
@RequestMapping("student")
public class StudentController extends BaseController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/hello")
    public ResponseData hello() {
        String hello = "hello";
        return success(hello);
    }

    @PostMapping("select")
    public ResponseData select(@RequestBody StudentReq req){
        StudentVo vo = studentService.select(req);
        return success(vo);
    }
}
