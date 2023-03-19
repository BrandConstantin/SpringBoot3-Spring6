package com.dependency.injection.springinjection.config;

import com.dependency.injection.springinjection.common.Coach;
import com.dependency.injection.springinjection.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
