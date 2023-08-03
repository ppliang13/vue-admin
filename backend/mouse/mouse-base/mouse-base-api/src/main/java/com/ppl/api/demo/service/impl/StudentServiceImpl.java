package com.ppl.api.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.ppl.api.demo.mapper.mapping.StudentMapping;
import com.ppl.api.demo.entity.model.dto.StudentDto;
import com.ppl.api.demo.entity.model.req.StudentReq;
import com.ppl.api.demo.entity.model.vo.StudentVo;
import com.ppl.api.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pisiliang on 2023/6/25 11:36
 */
@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentMapping studentMapping;

    public StudentVo getById(long id) {
        StudentDto studentDto = studentMapping.selectByIdDto(id);
        return transToVo(studentDto);
    }

    @Override
    public StudentVo select(StudentReq req) {

        return getById(req.getAge());
    }

    private StudentVo transToVo(StudentDto dto) {
        StudentVo vo = new StudentVo();
        BeanUtil.copyProperties(dto, vo);
        return vo;
    }

}
