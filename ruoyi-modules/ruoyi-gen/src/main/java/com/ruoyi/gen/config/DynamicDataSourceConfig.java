package com.ruoyi.gen.config;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.ruoyi.common.core.utils.SpringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态切换数据源配置
 *
 * @author zhangzhe
 */
@Configuration
public class DynamicDataSourceConfig {

    @Bean
    public Map<String, String> dynamicDataSourceMap() {
        DynamicRoutingDataSource dynamicRoutingDataSource = SpringUtils.getBean(DynamicRoutingDataSource.class);

        Map<String, String> map = new HashMap<>();
        dynamicRoutingDataSource.getDataSources().forEach((dataSourceName, dataSource) -> {
            try {
                Connection conn = dataSource.getConnection();
                String schema = conn.getCatalog();
                map.put(schema, dataSourceName);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        return Collections.unmodifiableMap(map);
    }

}
