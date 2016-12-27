package com.shanky.config;


import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.shanky.dao.CustomerDAO;
/**
 * Created by shanky on 9/12/16.
 */
@Configurable
@EnableWebMvc
@ComponentScan(basePackages = "com.shanky")
public class RootConfig {
    @Bean
    public CustomerDAO createcustomerDAO(){
        return new CustomerDAO();
    }



}
