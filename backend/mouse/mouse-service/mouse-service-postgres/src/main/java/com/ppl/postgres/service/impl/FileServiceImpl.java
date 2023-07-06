package com.ppl.postgres.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ppl.postgres.mapper.FileMapper;
import com.ppl.postgres.pojo.db.FileInfo;
import com.ppl.postgres.service.FileService;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;

/**
 * 文件下载
 * Created by pisiliang on 2023/7/6 14:48
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, FileInfo> implements FileService {


    public FileInfo savaFile(String fileURL) {
        if (StrUtil.isBlank(fileURL)) {
            throw new RuntimeException("文件路径不能为空");
        }
        File file = this.getFile(fileURL);
        try {
            FileInfo fileInfo = this.getFileInfo(file);
            if (this.saveFileInfo(fileInfo)) {
                fileInfo.setValue(null);
                return fileInfo;
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public InputStream getFileByUrl(Long id) throws SQLException {
        FileInfo fileInfo = getFileInfo(id);
        Blob value = fileInfo.getValue();
        return value.getBinaryStream();
    }



    private FileInfo getFileInfo(File file) throws IOException, SQLException {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileName(file.getName());
        fileInfo.setFileSize((int) (file.length() / 1024 / 1024));
        fileInfo.setFileUrl(file.getPath());
        fileInfo.setFileType(file.getName().substring(file.getName().lastIndexOf(".") + 1));
        InputStream inputStream = new FileInputStream(file);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        byte[] fileBytes = outputStream.toByteArray();
        MD5 md5 = new MD5();
        String md5Value = md5.digestHex16(fileBytes);
        fileInfo.setMd5(md5Value);
        fileInfo.setValue(new SerialBlob(fileBytes));
        return fileInfo;
    }



    private File getFile(String fileURL) {
        File file = new File(fileURL);
        if (!file.exists()) {
            throw new RuntimeException("文件不存在");
        }
        return file;
    }

    /**
     * 保存文件信息
     * @param fileInfo 文件信息
     * @return 是否保存成功
     */
    private Boolean saveFileInfo(FileInfo fileInfo) {
        return this.save(fileInfo);
    }


    /**
     * 根据id获取文件信息
     * @param id id
     * @return 文件信息
     */
    private FileInfo getFileInfo(Long id) {
        return this.getById(id);
    }
}
