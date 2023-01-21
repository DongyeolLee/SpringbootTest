package com.tobyspring.helloboot.controller;

import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tobyspring.helloboot.service.HelloService;

//@RestController
@RequestMapping
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {this.helloService = helloService;}

    @GetMapping("/hello")
    @ResponseBody
    public String hello(String name) {
        System.out.println("<<<<< Controller >>>>>");
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
