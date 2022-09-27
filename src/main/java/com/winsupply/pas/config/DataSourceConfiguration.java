package com.winsupply.pas.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;

/**
 * provides data source bean configurations using Spring jdbcTemplate<br>
 * data sources configured to various platforms, SQL, DB2 iSeries, TcAccess mainframe<br>
 *
 * akghumrawi Sept 2022
 */
@Configuration
@EnableConfigurationProperties
public class DataSourceConfiguration {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties as400DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "as400DataSource")
    public DataSource as400DataSource() {
        return as400DataSourceProperties().initializeDataSourceBuilder().build();
    }
    /**
     * JdBcTemplate for ops acct dataSource.
     * @return JdbcTemplate ( use with @qualifier(as400JdbcTemplate))
     */
    @Bean(name = "as400JdbcTemplate")
    public JdbcTemplate as400JdbcTemplate() {
        return new JdbcTemplate(as400DataSource());
    }



}
