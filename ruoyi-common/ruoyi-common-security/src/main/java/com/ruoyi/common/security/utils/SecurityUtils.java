package com.ruoyi.common.security.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.ruoyi.common.core.constant.CacheConstants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.core.utils.ServletUtils;

/**
 * 权限获取工具类
 * 
 * @author ruoyi
 */
public class SecurityUtils
{
    /**
     * 获取用户
     */
    public static String getUsername()
    {
        return ServletUtils.getRequest().getHeader(CacheConstants.DETAILS_USERNAME);
    }

    /**
     * 获取用户ID
     */
    public static Long getUserId()
    {
        return Convert.toLong(ServletUtils.getRequest().getHeader(CacheConstants.DETAILS_USER_ID));
    }

    /**
     * 是否为管理员
     * 
     * @param userId 用户ID
     * @return 结果
     */
    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }

    /**
     * 生成BCryptPasswordEncoder密码
     *
     * @param password 密码
     * @return 加密字符串
     */
    public static String encryptPassword(String password)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    /**
     * 判断密码是否相同
     *
     * @param rawPassword 真实密码
     * @param encodedPassword 加密后字符
     * @return 结果
     */
    public static boolean matchesPassword(String rawPassword, String encodedPassword)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
