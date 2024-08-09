package com.skypedal.skypedal_backend.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MapsClientConfig {
    @Value("${maps.api.routes-url}")
    private String baseRoutesUrl;

    @Value("${maps.api.places-url}")
    private String basePlacesUrl;

    @Value("${maps.api.token}")
    private String apiToken;

    @Bean
    @Qualifier("mapsPlacesClient")
    public WebClient mapsPlacesClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder.baseUrl(basePlacesUrl).defaultHeader("X-Goog-Api-Key",apiToken).build();
    }

    @Bean
    @Qualifier("mapsRoutesClient")
    public WebClient mapsRoutesClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder.baseUrl(baseRoutesUrl).defaultHeader("X-Goog-Api-Key",apiToken).build();
    }
}
