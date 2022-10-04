package de.myapp.ee.app.pattern.standard.microservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
