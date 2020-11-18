package com.ruoyi.file.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.file.utils.FileUploadUtils;

/**
 * 本地文件存储
 * 
 * @author ruoyi
 */
@Service
public class LocalSysFileServiceImpl implements ISysFileService
{
    /**
     * 文件上传接口
     * 
     * @param file 上传的文件
     * @param baseDir 相对应用的基目录
     * @return 文件名称
     * @throws Exception
     */
    public String uploadFile(MultipartFile file, String baseDir) throws Exception
    {
        return FileUploadUtils.upload(baseDir, file);
    }
}
