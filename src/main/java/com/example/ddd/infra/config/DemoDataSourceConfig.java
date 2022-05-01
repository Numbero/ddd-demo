package com.example.ddd.infra.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@MapperScan(basePackages = "com.example.ddd.infra.repository.dao", sqlSessionTemplateRef = "demoSqlSessionTemplate")
public class DemoDataSourceConfig {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Bean(name = "demoDataSource")
    public DataSource getDataSource(){
        HikariConfig config = new HikariConfig();
        config.setAutoCommit(true);
        config.setReadOnly(false);

        config.setDriverClassName(driverClassName);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);

        config.setMaxLifetime(1800000);
        config.setIdleTimeout(600000);
        config.setConnectionTimeout(30000);
        config.setMaximumPoolSize(3);
        config.setMinimumIdle(1);
        return new HikariDataSource(config);
    }

    @Bean("demoSqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("demoDataSource") DataSource dataSource,
                                                     @Value("classpath:mybatis/mybatis-config-demo.xml") Resource configLocation,
                                                     @Value("classpath:mybatis/mapper/demo/*.xml") Resource[] mapperLocations) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setConfigLocation(configLocation);
        bean.setMapperLocations(mapperLocations);
        return bean.getObject();
    }

    @Bean("demoSqlSessionTemplate")
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("demoSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean("demoPlatformTransactionManager")
    public PlatformTransactionManager getPlatformTransactionManager(@Qualifier("demoDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}
