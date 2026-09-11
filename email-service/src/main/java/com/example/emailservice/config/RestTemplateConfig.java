package com.example.emailservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import com.example.emailservice.RequestLoggingInterceptor;

@Configuration 
public class RestTemplateConfig {
    
    @Bean 
    public RestClient restClient()
    {
        RestClient restClient = RestClient
                                .builder()
                                .baseUrl("http://localhost:8080/api/v1")
                                .requestInterceptor(new RequestLoggingInterceptor())
                                .build();
        return restClient;
    }
}
