package com.codecool.spingboot_tasks.rest_api_client.config;

import com.codecool.spingboot_tasks.rest_api_client.httpclient.client.ProfileHttpClient;
import com.codecool.spingboot_tasks.rest_api_client.httpclient.error.RestTemplateResponseErrorHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import java.time.Duration;


@Configuration
public class Config {

    @Bean
    RestTemplateResponseErrorHandler restTemplateResponseErrorHandler(){
        return new RestTemplateResponseErrorHandler();
    }

    @Bean
    RestTemplate restTemplate(@Value("${profile.http.client.config.connectionTimeout}") long connectionTimeout,
                              @Value("${profile.http.client.config.readTimeout}") long readTimeout,
                              RestTemplateResponseErrorHandler errorHandler){
        return new RestTemplateBuilder()
                .errorHandler(errorHandler)
                .setConnectTimeout(Duration.ofMillis(connectionTimeout))
                .setReadTimeout(Duration.ofMillis(readTimeout))
                .build();
    }
    @Bean
    ProfileHttpClient profileHttpClient(RestTemplate restTemplate, @Value("${product.http.client.config.uri:http://example.com}") String uri){
        return new ProfileHttpClient(restTemplate,uri);
    }
}
