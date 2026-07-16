package com.harsh;

public class Laptop implements Computer{
    public Laptop(){
        System.out.println("laptop constructor");
    }
    @Override
    public void compile(){
        System.out.println("I am laptop");
    }
}
