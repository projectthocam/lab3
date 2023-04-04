package com.fptaptech.lab3;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebMvcAutoConfig implements WebMvcConfigurer {
    String myExternalFilePath = "file:D:/files/"; // end your path with a /

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations(myExternalFilePath);
    }
}
