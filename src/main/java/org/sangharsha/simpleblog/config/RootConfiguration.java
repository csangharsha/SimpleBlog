/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sangharsha.simpleblog.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author Sangharsha
 */
@Configuration
@ComponentScan(basePackages = {"org.sangharsha.simpleblog"}, 
                    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class))
public class RootConfiguration {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_project1");
        dataSource.setUsername("root");
        dataSource.setPassword("Error$404");
        return dataSource;
    }
}