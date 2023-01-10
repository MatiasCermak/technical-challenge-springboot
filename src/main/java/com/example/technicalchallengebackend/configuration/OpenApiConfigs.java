package com.example.technicalchallengebackend.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfigs {
    @Bean
    public OpenAPI config() {
        return new OpenAPI()
                .components(new Components())
                .info(info());
    }

    private Info info() {
        return new Info()
                .title("Technical Challenge Springboot API")
                .description("Api documentation for a SpringBoot project made for a technical challenge.");
    }
}
