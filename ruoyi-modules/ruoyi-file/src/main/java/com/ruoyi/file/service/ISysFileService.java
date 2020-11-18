package com.ruoyi.file.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传接口
 * 
 * @author ruoyi
 */
public interface ISysFileService
{
    /**
     * 文件上传接口
     * 
     * @param file 上传的文件
     * @param baseDir 相对应用的基目录
     * @return 文件名称
     * @throws Exception
     */
    public String uploadFile(MultipartFile file, String baseDir) throws Exception;
}
