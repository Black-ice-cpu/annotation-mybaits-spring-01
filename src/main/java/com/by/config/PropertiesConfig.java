package com.by.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author ice
 */
@Data
@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertiesConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String userName;
    @Value("${jdbc.password}")
    private String passWord;
    @Value("${mybatis.entity.path}")
    private String mybatisEntity;
    private String mapperLocations;


}
