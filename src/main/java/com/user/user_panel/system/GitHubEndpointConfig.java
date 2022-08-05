package com.user.user_panel.system;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
@ConfigurationProperties(prefix = "integration-point.git-hub-api")
@NoArgsConstructor
@Setter
@Getter
class GitHubEndpointConfig {
    private String url;

    private Duration readTimeout;
}
