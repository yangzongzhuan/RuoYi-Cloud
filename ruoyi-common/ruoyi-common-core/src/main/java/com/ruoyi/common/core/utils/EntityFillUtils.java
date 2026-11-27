package com.ruoyi.common.core.utils;

import com.ruoyi.common.core.exception.ServiceException;
import com.ruoyi.common.core.web.domain.BaseEntity;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 实体填充工具类
 *
 * @author 李佳琦
 * @date 2026/2/27 16:44
 */
public class EntityFillUtils {

    /**
     * 填充实体*
     *
     * @param entity 实体对象
     * @return 填充后的实体对象
     */
    public static <T extends BaseEntity> T fillEntity(T entity) {
        return EntityFillUtils.fillEntity(entity, null, null);
    }

    /**
     * 填充实体*
     *
     * @param entity 实体对象
     * @param username 用户名
     * @return 填充后的实体对象
     */
    public static <T extends BaseEntity> T fillEntity(T entity, String username) {
        return EntityFillUtils.fillEntity(entity, null, username);
    }

    /**
     * 填充实体
     *
     * @param entity 实体对象
     * @param idField id字段名
     * @param username 用户名
     * @return 填充后的实体对象
     */
    public static <T extends BaseEntity> T fillEntity(T entity, String idField, String username) {
        Class<? extends BaseEntity> clazz = entity.getClass();
        // 如果idField为空，则默认为Id
        if (idField == null || idField.isEmpty()) {
            idField = "id";
        }
        // idField首字母大写
        idField = StringUtils.capitalize(idField);

        Method getId = null;
        try {
            getId = clazz.getMethod("get" + idField);
        } catch (Exception e) {
            throw new ServiceException("缺失基础字段: " + idField);
        }
        try {
            Date now = DateUtils.getNowDate();
            // 新增
            if (getId.invoke(entity) == null) {
                clazz.getMethod("setCreateBy", String.class).invoke(entity, username);
                clazz.getMethod("setCreateTime", Date.class).invoke(entity, now);
            }
            clazz.getMethod("setUpdateBy", String.class).invoke(entity, username);
            clazz.getMethod("setUpdateTime", Date.class).invoke(entity, now);
            clazz.getMethod("setDelFlag", String.class).invoke(entity, "0");
        } catch (Exception e) {
            throw new ServiceException("调起函数异常");
        }
        return entity;
    }
}
