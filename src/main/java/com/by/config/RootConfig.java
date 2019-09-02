package com.by.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


/**
 * @author ice
 */
@Configuration
@PropertySource("classpath:datasource.properties")
@MapperScan("${mybatis.mapper.path}")
@ComponentScan("com.by.config")
public class RootConfig {
    @Autowired
    PropertiesConfig propertiesConfig;
    /**
     * 配置数据源
     * @return
     */
    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(propertiesConfig.getDriver());
        druidDataSource.setUrl(propertiesConfig.getUrl());
        druidDataSource.setUsername(propertiesConfig.getUserName());
        druidDataSource.setPassword(propertiesConfig.getPassWord());
        return druidDataSource;
    }

    /**
     *配置SqlSessionFactory
     * @param dataSource
     * @return
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(propertiesConfig.getMybatisEntity());
        return sqlSessionFactoryBean;
    }
}
