package com.ppl.api.demo.mapper.mapping;

import cn.hutool.core.bean.BeanUtil;
import com.ppl.api.demo.mapper.StudentMapper;
import com.ppl.api.demo.entity.model.db.StudentDb;
import com.ppl.api.demo.entity.model.dto.StudentDto;
import org.springframework.stereotype.Service;

/**
 * Created by pisiliang on 2023/6/25 11:41
 */
@Service
public class StudentMapping implements StudentMapper {


    @Override
    public StudentDb selectById(Long id) {
        StudentDb studentDb = new StudentDb();
        studentDb.setName("ppl");
        studentDb.setAge(18);
        studentDb.setSex(true);
        return studentDb;
    }

    public StudentDto selectByIdDto(Long id) {
        StudentDb db = selectById(id);
        return transToDto(db);
    }

    private  StudentDto transToDto(StudentDb db) {
        StudentDto dto = new StudentDto();
        BeanUtil.copyProperties(db, dto);
        return dto;
    }
}
