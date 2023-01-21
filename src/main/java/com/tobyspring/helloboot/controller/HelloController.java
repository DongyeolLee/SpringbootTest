package com.tobyspring.helloboot.controller;

import java.util.Objects;

import com.tobyspring.helloboot.service.HelloService;

//@RestController
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {this.helloService = helloService;}

    //    @GetMapping("/hello")
    public String hello(String name) {
        System.out.println("<<<<< Controller >>>>>");
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
