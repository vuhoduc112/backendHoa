package com.example.hoa.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Cho phép tất cả các nguồn gốc
        config.setAllowedOrigins(Collections.singletonList("*"));

        // Cho phép các phương thức HTTP (GET, POST, PUT, DELETE, vv.)
        config.addAllowedMethod("*");

        // Cho phép các tiêu đề tùy chỉnh và tiêu đề thông thường
        config.addAllowedHeader("*");

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
