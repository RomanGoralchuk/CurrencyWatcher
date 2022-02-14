package com.currency.crypto.goralchuk.watcher.config;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@Configuration
@EnableJpaRepositories
@EnableWebMvc
public class WebConfig {

    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }
}
