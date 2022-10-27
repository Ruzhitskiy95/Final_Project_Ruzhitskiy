package by.academy.configuration;

import org.springframework.context.annotation.Bean;


public class ModelMapper {
    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }
}