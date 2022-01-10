package com.ruoyi.common.datasource.env;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * seata 在 springboot 2.6.x 存在循环引用问题的处理
 *
 * @author ruoyi
 */
public class ApplicationSeataInitializer implements EnvironmentPostProcessor, Ordered
{
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application)
    {
        System.setProperty("spring.main.allow-circular-references", "true");
    }

    @Override
    public int getOrder()
    {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
