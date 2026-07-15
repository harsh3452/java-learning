package com.harsh.dependencyinjection_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Dev {
    //Field Dependency Injection
    //@Autowired
//    private Laptop laptop; //hard coded as laptop

    //Constructor Dependency Injection
//     public Dev(Laptop laptop){
//        this.laptop=laptop;
//    }

    //Setter DI
//    @Autowired
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }


    @Autowired
    @Qualifier("laptop")
    private Computer computer;


    public void build(){
        computer.compile();
        System.out.println("I am pretending to work!! Dont' Disturb!!");
    }
}
