package org.example.pkmn.config;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfig {

    @Bean("pkmnDapiRestTemplate")
    public RestTemplate pkmnDapiRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(120))
                .setReadTimeout(Duration.ofSeconds(120))
                .build();
    }
}
