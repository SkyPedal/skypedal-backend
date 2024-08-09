package com.skypedal.skypedal_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MapsClientConfig {

    @Bean
    public WebClient mapsClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder.baseUrl("https://routes.googleapis.com").defaultHeader("X-Goog-Api-Key","testkey").build();
    }
}
