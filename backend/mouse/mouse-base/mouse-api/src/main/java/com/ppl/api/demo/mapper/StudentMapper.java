package com.ppl.api.demo.mapper;

import com.ppl.api.demo.pojo.model.db.StudentDb;
import com.ppl.api.demo.pojo.model.dto.StudentDto;

/**
 * Created by pisiliang on 2023/6/25 11:37
 */
public interface StudentMapper {

    StudentDb selectById(Long id);

    StudentDto selectByIdDto(Long id);
}
