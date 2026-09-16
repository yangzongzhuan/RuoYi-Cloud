package com.ruoyi.common.security.utils.poi;

import java.util.List;
import org.springframework.stereotype.Component;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.core.utils.poi.ExcelDictDataConverter​;
import com.ruoyi.common.security.utils.DictUtils;
import com.ruoyi.system.api.domain.SysDictData;

/**
 * 字典数据转换
 *
 * @author ruoyi
 */
@Component
public class DictDataConverter implements ExcelDictDataConverter​
{
    /**
     * 分隔符
     */
    public static final String SEPARATOR = ",";

    /**
     * 根据字典类型和字典值获取字典标签
     * 
     * @param dictType 字典类型
     * @param dictValue 字典值
     * @return 字典标签
     */
    @Override
    public String getDictLabel(String dictType, String dictValue, String separator)
    {
        if (StringUtils.isEmpty(dictValue))
        {
            return StringUtils.EMPTY;
        }
        return DictUtils.getDictLabel(dictType, dictValue, separator);
    }

    /**
     * 根据字典类型和字典标签获取字典值
     * 
     * @param dictType 字典类型
     * @param dictLabel 字典标签
     * @return 字典值
     */
    @Override
    public String getDictValue(String dictType, String dictLabel, String separator)
    {
        if (StringUtils.isEmpty(dictLabel))
        {
            return StringUtils.EMPTY;
        }
        return DictUtils.getDictValue(dictType, dictLabel, separator);
    }

    /**
     * 根据字典类型获取字典所有标签
     *
     * @param dictType 字典类型
     * @return 字典值
     */
    @Override
    public String getDictLabels(String dictType)
    {
        StringBuilder propertyString = new StringBuilder();
        List<SysDictData> datas = DictUtils.getDictCache(dictType);
        if (StringUtils.isNull(datas))
        {
            return StringUtils.EMPTY;
        }
        for (SysDictData dict : datas)
        {
            propertyString.append(dict.getDictLabel()).append(SEPARATOR);
        }
        return StringUtils.stripEnd(propertyString.toString(), SEPARATOR);
    }
}
