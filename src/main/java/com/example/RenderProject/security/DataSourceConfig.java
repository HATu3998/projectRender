package com.example.RenderProject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/apidemo");
//        dataSource.setUsername("root");
//        dataSource.setPassword("");
//        return dataSource;
//    }
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver"); // Sử dụng driver của PostgreSQL
        dataSource.setUrl("jdbc:postgresql://dpg-ckigog212bvs738pfmvg-a.oregon-postgres.render.com:5432/renderproduct");
        dataSource.setUsername("renderproduct_user");
        dataSource.setPassword("1AB43lwOucjXHoAHeBgONXYZoZH5vtKW");
        return dataSource;
    }
}
