package com.accelerator.spring.automationaccelerator.config;

import com.accelerator.spring.automationaccelerator.annotations.LazyConfiguration;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker getFaker(){
        return new Faker();
    }
}
