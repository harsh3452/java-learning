package com.harsh;

public class Desktop implements Computer{
    public Desktop(){
        System.out.println("Desktop Constructor");
    }
    @Override
    public void compile() {
        System.out.println("I am desktop");
    }
}
