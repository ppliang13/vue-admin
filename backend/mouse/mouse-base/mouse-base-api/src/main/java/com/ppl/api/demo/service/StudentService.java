package com.ppl.api.demo.service;

import com.ppl.api.demo.entity.model.req.StudentReq;
import com.ppl.api.demo.entity.model.vo.StudentVo;

/**
 * Created by pisiliang on 2023/6/25 11:36
 */
public interface StudentService {

    StudentVo getById(long id);

    StudentVo select(StudentReq req);
}
