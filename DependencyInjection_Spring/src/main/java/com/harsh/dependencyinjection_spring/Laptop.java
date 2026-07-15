package com.harsh.dependencyinjection_spring;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {

    @Override
    public void compile(){
        System.out.println("I am compiling codes, its all binary it sucks");
    }
}
