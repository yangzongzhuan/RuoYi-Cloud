package com.ruoyi.common.core.utils.poi;

/**
 * Excel导入图片处理器 
 * 文件存储由独立的 ruoyi-file 服务提供
 *
 * @author ruoyi
 */
public interface ExcelImageHandler
{
    /**
     * 上传Excel中内嵌的图片，返回图片访问地址
     *
     * @param data 图片字节数组
     * @param extension 图片扩展名（不含点，如 jpg、png、gif、bmp）
     * @return 图片上传后的访问地址
     */
    String upload(byte[] data, String extension);
}
