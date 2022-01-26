package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean("gril")
    Girl girlFriendConfig(Dress dress) {
        return new Girl(dress);
    }

    @Bean("dress")
    Dress dress() {
        return new Dress(20);
    }
}
