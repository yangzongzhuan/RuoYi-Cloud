package com.ruoyi.system.api.handler;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.exception.ServiceException;
import com.ruoyi.common.core.utils.poi.ExcelImageHandler;
import com.ruoyi.system.api.RemoteFileService;
import com.ruoyi.system.api.domain.SysFile;

/**
 * Excel图片导入处理器
 *
 * 将Excel中内嵌的图片字节封装为 {@link MultipartFile}，通过 Feign 调用 ruoyi-file
 * 服务的 /upload 接口上传，返回文件服务生成的图片访问地址，最终写入实体的图片字段
 *
 * @author ruoyi
 */
public class RemoteExcelImageHandler implements ExcelImageHandler
{
    private static final Logger log = LoggerFactory.getLogger(RemoteExcelImageHandler.class);

    private final RemoteFileService remoteFileService;

    public RemoteExcelImageHandler(RemoteFileService remoteFileService)
    {
        this.remoteFileService = remoteFileService;
    }

    @Override
    public String upload(byte[] data, String extension)
    {
        String fileName = "excel_image" + "." + extension;
        MultipartFile file = new InMemoryMultipartFile(fileName, data, "image/" + extension);
        R<SysFile> result;
        try
        {
            result = remoteFileService.upload(file);
        }
        catch (Exception e)
        {
            log.error("Excel图片上传调用文件服务异常", e);
            throw new ServiceException("图片上传失败：文件服务调用异常");
        }
        if (result == null || result.getCode() != R.SUCCESS || result.getData() == null)
        {
            String msg = result == null ? "文件服务无响应" : result.getMsg();
            throw new ServiceException("图片上传失败：" + msg);
        }
        return result.getData().getUrl();
    }

    /**
     * 基于字节数组的内存MultipartFile实现，用于Feign以multipart/form-data方式上传字节数据
     */
    public static class InMemoryMultipartFile implements MultipartFile
    {
        /** 表单参数名，与 ruoyi-file 上传接口的参数名保持一致 */
        private final String name = "file";

        private final String originalFilename;

        private final String contentType;

        private final byte[] content;

        public InMemoryMultipartFile(String originalFilename, byte[] content, String contentType)
        {
            this.originalFilename = originalFilename;
            this.content = content;
            this.contentType = contentType;
        }

        @Override
        public String getName()
        {
            return name;
        }

        @Override
        public String getOriginalFilename()
        {
            return originalFilename;
        }

        @Override
        public String getContentType()
        {
            return contentType;
        }

        @Override
        public boolean isEmpty()
        {
            return content == null || content.length == 0;
        }

        @Override
        public long getSize()
        {
            return content.length;
        }

        @Override
        public byte[] getBytes() throws IOException
        {
            return content;
        }

        @Override
        public InputStream getInputStream() throws IOException
        {
            return new ByteArrayInputStream(content);
        }

        @Override
        public void transferTo(File dest) throws IOException, IllegalStateException
        {
            Files.copy(getInputStream(), dest.toPath());
        }
    }
}
