package com.ruoyi.common.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.TimeZone;
import org.springframework.context.annotation.Bean;

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
    public ObjectMapper objectMapper()
    {
        ObjectMapper objectMapper = JsonMapper.builder().build();
        objectMapper.findAndRegisterModules();
        objectMapper.setTimeZone(TimeZone.getDefault());
        return objectMapper;
    }
}
