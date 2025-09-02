package com.ruoyi.file.config;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.DispatcherType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ruoyi.file.filter.RefererFilter;

/**
 * Filter配置
 *
 * @author ruoyi
 */
@Configuration
public class FilterConfig
{
    /**
     * 资源映射路径 前缀
     */
    @Value("${file.prefix}")
    public String localFilePrefix;
    
    @Value("${referer.allowed-domains}")
    private String allowedDomains;
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    @ConditionalOnProperty(value = "referer.enabled", havingValue = "true")
    public FilterRegistrationBean refererFilterRegistration()
    {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new RefererFilter());
        registration.addUrlPatterns(localFilePrefix + "/*");
        registration.setName("refererFilter");
        registration.setOrder(FilterRegistrationBean.HIGHEST_PRECEDENCE);
        Map<String, String> initParameters = new HashMap<String, String>();
        initParameters.put("allowedDomains", allowedDomains);
        registration.setInitParameters(initParameters);
        return registration;
    }
}
