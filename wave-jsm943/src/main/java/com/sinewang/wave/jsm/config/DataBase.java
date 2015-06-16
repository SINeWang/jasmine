package com.sinewang.wave.jsm.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by wangyanjiong on 6/16/15.
 */

@Configuration
@PropertySource(value = "classpath:jsm.properties")
@MapperScan("com.sinewang.wave.jsm.dao")
public class DataBase implements EnvironmentAware {

    private Logger log = LoggerFactory.getLogger(DataBase.class);

    private Environment environment;

    public void setEnvironment(final Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource dataSource() {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {

            dataSource.setDriverClass(environment.getProperty("jsm.db.driverClass"));
            dataSource.setUser(environment.getProperty("jsm.db.user"));
            dataSource.setPassword(environment.getProperty("jsm.db.password"));
            dataSource.setJdbcUrl(environment.getProperty("jsm.db.jdbcUrl"));
            dataSource.setTestConnectionOnCheckin(true);
            dataSource.setTestConnectionOnCheckout(true);
            dataSource.setMaxPoolSize(Integer.parseInt(environment.getProperty("jsm.db.maxPoolSize")));
        } catch (Throwable e) {
            if (log.isErrorEnabled()) {
                log.error("failed to initialize data source", e);
            }
        }
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setTypeAliasesPackage("com.sinewang.wave.jsm.model");
        return sessionFactory;
    }
}
