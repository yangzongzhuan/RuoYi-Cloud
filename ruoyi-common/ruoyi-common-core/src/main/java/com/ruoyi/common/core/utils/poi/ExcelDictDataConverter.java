package com.ruoyi.common.core.utils.poi;

/**
 * Excel字典数据转换
 *
 * @author ruoyi
 */
public interface ExcelDictDataConverter
{
    /**
     * 根据字典类型和字典键值获取字典标签
     *
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    String getDictLabel(String dictType, String dictValue, String separator);

    /**
     * 根据字典类型和字典标签获取字典键值
     *
     * @param dictType 字典类型
     * @param dictLabel 字典标签
     * @return 字典键值
     */
    String getDictValue(String dictType, String dictLabel, String separator);

    /**
     * 根据字典类型获取字典标签列表
     *
     * @param dictType 字典类型
     * @return 字典标签列表
     */
    String getDictLabels(String dictType);
}
