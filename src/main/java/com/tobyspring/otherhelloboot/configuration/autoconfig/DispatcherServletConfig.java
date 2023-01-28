package com.tobyspring.otherhelloboot.configuration.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

import com.tobyspring.otherhelloboot.configuration.MyAutoConfiguration;

@MyAutoConfiguration
public class DispatcherServletConfig {
    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }
}
