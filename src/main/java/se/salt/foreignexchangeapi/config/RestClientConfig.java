package se.salt.foreignexchangeapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {
    @Bean
    public RestClient restClient(@Value("${fx.base-url}") String baseUrl){
        return RestClient.builder().baseUrl(baseUrl).build();
    }
}
