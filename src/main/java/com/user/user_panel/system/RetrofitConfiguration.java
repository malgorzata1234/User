package com.user.user_panel.system;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.user.user_panel.business.user.control.GitHubApi;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Configuration
@RequiredArgsConstructor
public class RetrofitConfiguration {


    @Bean
    public GitHubApi apiGitHub(GitHubEndpointConfig gitHubEndpointConfig) {
        return createInternal(gitHubEndpointConfig.getUrl(), gitHubEndpointConfig.getReadTimeout())
                .create(GitHubApi.class);
    }

    private Retrofit createInternal(String url, Duration readTimeout) {
        return (new Retrofit.Builder())
                .client(create(readTimeout))
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .create()))
                .baseUrl(url).build();
    }

    public OkHttpClient create(Duration readTimeout) {
        OkHttpClient.Builder builder = (new OkHttpClient.Builder())
                .readTimeout(readTimeout.toMillis(), TimeUnit.MILLISECONDS);
        Objects.requireNonNull(builder);
        return builder.build();
    }
}
