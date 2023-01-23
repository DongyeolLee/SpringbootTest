package com.tobyspring.helloboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tobyspring.helloboot.controller.HelloController;
import com.tobyspring.helloboot.service.HelloService;
import com.tobyspring.helloboot.service.SimpleHelloService;

@Configuration
public class SimpleConfiguration {

    @Bean
    public HelloController helloController(HelloService helloService) {
        return new HelloController(helloService);
    }

    @Bean
    public HelloService helloService() {
        return new SimpleHelloService();
    }
}
