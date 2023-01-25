package com.tobyspring.helloboot.controller;

import java.util.Objects;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tobyspring.helloboot.service.HelloService;

//@RestController
@RequestMapping
@Component
public class HelloController {
    private final HelloService helloService;
    private final ApplicationContext applicationContext;

    public HelloController(HelloService helloService, ApplicationContext applicationContext) {
        this.helloService = helloService;
        this.applicationContext = applicationContext;

        System.out.println(applicationContext);
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(String name) {
        System.out.println("<<<<< Controller >>>>>");
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
