package com.example.apiversioning.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
           @Override
           public void configureApiVersioning(ApiVersionConfigurer configurer){
            configurer
            .addSupportedVersions("1.0.0","1.1.0","2.0.0")
            .setDefaultVersion("1.0.0")
            .usePathSegment(1)
            // .useRequestHeader("X-API-Version")
            .setVersionParser(new ApiVersionParser());
              
           }
}
