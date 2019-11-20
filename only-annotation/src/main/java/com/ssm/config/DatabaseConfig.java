package com.ssm.config;

import org.apache.ibatis.logging.log4j.Log4jImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


/**
 * @author ljh
 */
@Configuration
@PropertySource(value = "classpath:jdbc.properties",encoding = "UTF-8")
@MapperScan(value="com.ssm.dao")
public class DatabaseConfig {
    @Value("${db.driverClass}")
    public String driver;
    @Value("${db.url}")
    public String url;
    @Value("${db.username}")
    public String username;
    @Value("${db.password}")
    public String password;
    @Value("${db.initialSize}")
    public int initialSize;
    @Value("${db.maxActive}")
    public int maxActive;
    @Value("${db.maxIdle}")
    public int maxIdle;
    @Value("${db.minIdle}")
    public int minIdle;
    @Value("${db.maxWait}")
    public int maxWait;



    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        return dataSource;
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        org.apache.ibatis.session.Configuration configuration=new org.apache.ibatis.session.Configuration();
        configuration.setLogImpl(Log4jImpl.class);
        sessionFactory.setDataSource(dataSource());
        return sessionFactory.getObject();
    }

}
