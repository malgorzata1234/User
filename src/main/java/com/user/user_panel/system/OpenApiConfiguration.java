package com.user.user_panel.system;

import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI();
    }

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .setGroup("api")
                .pathsToMatch("/api/**")
                .build();
    }
}

