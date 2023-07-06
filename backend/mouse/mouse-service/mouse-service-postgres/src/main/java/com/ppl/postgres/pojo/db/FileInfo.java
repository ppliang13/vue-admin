package com.ppl.postgres.pojo.db;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Blob;

/**
 * Created by pisiliang on 2023/7/6 14:39
 */
@Data
@TableName("file_info")
public class FileInfo {
    /**
     * 文件的md5
     */
    private String md5;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 文件路径
     */
    private String fileUrl;
    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文件大小 M
     */
    private Integer fileSize;
    /**
     * 文件内容
     */
    private Blob value;
}
