package com.currency.crypto.goralchuk.watcher.config;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class WebConfig {

    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }
}
