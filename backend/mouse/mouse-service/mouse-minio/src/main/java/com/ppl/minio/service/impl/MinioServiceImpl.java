package com.ppl.minio.service.impl;

import cn.hutool.core.util.StrUtil;
import com.ppl.minio.config.MinioProp;
import com.ppl.minio.service.MinioService;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by pisiliang on 2023/6/25 14:29
 */
@Service
public class MinioServiceImpl implements MinioService {

    @Autowired
    private MinioClient minioClient;
    @Autowired
    private MinioProp minioProp;

    @Override
    public String uploadFile(String bucketName, String fileName, MultipartFile file)  {
        createBucket();
        if (StrUtil.isBlank(bucketName)) {
            bucketName = minioProp.getBucket();
        }
        // 新的文件名 = 存储桶名称_时间戳_文件名称.后缀名
        if(fileName == null || "".equals(fileName)){
            fileName = minioProp.getBucket() + "_" + System.currentTimeMillis() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        }
        // 开始上传
        try {
            minioClient.putObject(bucketName, fileName, file.getInputStream(), file.getContentType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bucketName + "/" + minioProp.getBucket() + "/" + fileName;
    }

    @Override
    public void downloadFile(String bucketName, String fileName, MultipartFile file)  {

    }

    @Override
    public void deleteFile(String bucketName, String fileName)  {

    }

    @Override
    public void deleteFileList(String bucketName, List<String> fileName) {
        if(fileName != null && fileName.size() > 0){
            for (String name : fileName) {
                deleteFile(bucketName,name);
            }
        }
    }

    @Override
    public boolean fileExists(String bucketName, String fileName)  {
        return false;
    }

    


    /**
     * 判断桶是否存在（不存在就创建）
     */
    private void createBucket() {
        try {
            // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
            MinioClient minioClient = new MinioClient(minioProp.getEndpoint(), minioProp.getAccessKey(), minioProp.getSecretKey());
            // 检查存储桶是否已经存在
            boolean isExist = minioClient.bucketExists(minioProp.getBucket());
            if (!isExist) {
                // 创建一个存储桶
                minioClient.makeBucket(minioProp.getBucket());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
