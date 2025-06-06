package com.ruoyi.file.service;

import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.nacos.common.utils.IoUtils;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.file.config.MinioConfig;
import com.ruoyi.file.utils.FileUploadUtils;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;

/**
 * Minio 文件存储
 *
 * @author ruoyi
 */
@Service
public class MinioSysFileServiceImpl implements ISysFileService
{
    @Autowired
    private MinioConfig minioConfig;

    @Autowired
    private MinioClient client;

    /**
     * Minio文件上传接口
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
            String fileName = FileUploadUtils.extractFilename(file);
            inputStream = file.getInputStream();
            PutObjectArgs args = PutObjectArgs.builder()
                    .bucket(minioConfig.getBucketName())
                    .object(fileName)
                    .stream(inputStream, file.getSize(), -1)
                    .contentType(file.getContentType())
                    .build();
            client.putObject(args);
            return minioConfig.getUrl() + "/" + minioConfig.getBucketName() + "/" + fileName;
        }
        catch (Exception e)
        {
            throw new RuntimeException("Minio Failed to upload file", e);
        }
        finally
        {
            IoUtils.closeQuietly(inputStream);
        }
    }

    /**
     * Minio文件删除接口
     * 
     * @param fileUrl 文件访问URL
     * @throws Exception
     */
    @Override
    public void deleteFile(String fileUrl) throws Exception
    {
        try
        {
            String minioFile = StringUtils.substringAfter(fileUrl, minioConfig.getBucketName());
            client.removeObject(RemoveObjectArgs.builder().bucket(minioConfig.getBucketName()).object(minioFile).build());
        }
        catch (Exception e)
        {
            throw new RuntimeException("Minio Failed to delete file", e);
        }
    }
}
