package com.tobyspring.helloboot;

import org.springframework.boot.SpringApplication;

import com.tobyspring.otherhelloboot.configuration.MySpringBootApplication;

//@ComponentScan
@MySpringBootApplication
public class HellobootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }

//    public static void main(String[] args) {
//        MySpringApplication.run(HellobootApplication.class, args);
//    }
}
