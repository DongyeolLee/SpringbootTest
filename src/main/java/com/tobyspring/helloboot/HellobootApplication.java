package com.tobyspring.helloboot;

import org.springframework.boot.SpringApplication;

//@ComponentScan
@MySpringAnnotation
public class HellobootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }

//    public static void main(String[] args) {
//        MySpringApplication.run(HellobootApplication.class, args);
//    }
}
