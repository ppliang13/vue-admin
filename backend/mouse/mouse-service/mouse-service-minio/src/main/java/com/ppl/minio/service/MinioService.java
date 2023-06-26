package com.ppl.minio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by pisiliang on 2023/6/25 14:28
 */
public interface MinioService {


    //文件上传
    String uploadFile(String bucketName, String fileName, MultipartFile file) ;

    //文件下载
    void downloadFile(String bucketName, String fileName, MultipartFile file) ;

    //文件删除
    void deleteFile(String bucketName, String fileName) ;
    
    
    void deleteFileList(String bucketName, List<String> fileName) ;

    //文件是否存在
    boolean fileExists(String bucketName, String fileName) ;
}
