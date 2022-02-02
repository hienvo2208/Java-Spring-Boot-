package com.example.sp6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    SimpleBean simpleBean(){
        return new SimpleBean("HanhThan");
    }
}
