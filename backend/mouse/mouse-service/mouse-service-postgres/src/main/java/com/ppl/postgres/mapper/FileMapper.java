package com.ppl.postgres.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ppl.postgres.pojo.db.FileInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by pisiliang on 2023/7/6 14:18
 */
@Mapper
public interface FileMapper extends BaseMapper<FileInfo> {


}
