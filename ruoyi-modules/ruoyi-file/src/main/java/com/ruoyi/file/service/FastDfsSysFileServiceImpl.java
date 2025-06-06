package com.ruoyi.file.service;

import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.nacos.common.utils.IoUtils;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.ruoyi.common.core.utils.file.FileTypeUtils;

/**
 * FastDFS 文件存储
 *
 * @author ruoyi
 */
@Service
public class FastDfsSysFileServiceImpl implements ISysFileService
{
    /**
     * 域名或本机访问地址
     */
    @Value("${fdfs.domain}")
    public String domain;

    @Autowired
    private FastFileStorageClient storageClient;

    /**
     * FastDfs文件上传接口
     *
     * @param file 上传的文件
     * @return 访问地址
     * @throws Exception
     */
    @Override
    public String uploadFile(MultipartFile file) throws Exception
    {
        InputStream inputStream = null;
        try
        {
            inputStream = file.getInputStream();
            StorePath storePath = storageClient.uploadFile(inputStream, file.getSize(), FileTypeUtils.getExtension(file), null);
            return domain + "/" + storePath.getFullPath();
        }
        catch (Exception e)
        {
            throw new RuntimeException("FastDfs Failed to upload file", e);
        }
        finally
        {
            IoUtils.closeQuietly(inputStream);
        }
    }

    /**
     * FastDFS文件删除接口
     * 
     * @param fileUrl 文件访问URL
     * @throws Exception
     */
    @Override
    public void deleteFile(String fileUrl) throws Exception
    {
        try
        {
            StorePath storePath = StorePath.parseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        }
        catch (Exception e)
        {
            throw new RuntimeException("FastDfs Failed to delete file: ", e);
        }
    }
}
