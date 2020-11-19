package com.ruoyi.file.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.file.utils.FileUploadUtils;

/**
 * 本地文件存储
 * 
 * @author ruoyi
 */
@Primary
@Service
public class LocalSysFileServiceImpl implements ISysFileService
{
    /**
     * 资源映射路径 前缀
     */
    @Value("${file.prefix}")
    public String localFilePrefix;

    /**
     * 域名或本机访问地址
     */
    @Value("${file.domain}")
    public String domain;

    /**
     * 本地文件上传接口
     * 
     * @param file 上传的文件
     * @param baseDir 相对应用的基目录
     * @return 访问地址
     * @throws Exception
     */
    public String uploadFile(MultipartFile file, String baseDir) throws Exception
    {
        String name = FileUploadUtils.upload(baseDir, file);
        String url = domain + localFilePrefix + name;
        return url;
    }
}
