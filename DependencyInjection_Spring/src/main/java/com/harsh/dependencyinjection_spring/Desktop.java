package com.harsh.dependencyinjection_spring;


import org.springframework.stereotype.Component;
//@Primary
@Component
public class Desktop implements Computer{

    @Override
    public void compile() {
        System.out.println("I compile faster hahaha!");
    }
}
