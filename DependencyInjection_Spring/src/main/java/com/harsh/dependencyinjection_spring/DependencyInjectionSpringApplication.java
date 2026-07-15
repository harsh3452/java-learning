package com.harsh.dependencyinjection_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionSpringApplication {

    public static void main(String[] args) {
        ApplicationContext  context = SpringApplication.run(DependencyInjectionSpringApplication.class, args);
        Dev dev = context.getBean(Dev.class);
        dev.build();
    }

}
