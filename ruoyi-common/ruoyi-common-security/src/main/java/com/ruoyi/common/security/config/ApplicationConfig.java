package com.ruoyi.common.security.config;

import java.util.TimeZone;
import org.springframework.context.annotation.Bean;
import tools.jackson.databind.json.JsonMapper.Builder;

/**
 * 系统配置
 *
 * @author ruoyi
 */
public class ApplicationConfig
{
    /**
     * 时区配置
     */
    @Bean
    public tools.jackson.databind.json.JsonMapper jacksonJsonMapper(Builder builder)
    {
        return builder.defaultTimeZone(TimeZone.getTimeZone("GMT+8")).build();
    }
}
