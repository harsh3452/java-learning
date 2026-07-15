package com.harsh;

public class Dev {

    private Laptop laptop;
    private int age;
     private int salary;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public Dev(){
        System.out.println("Dev Constructor");
    }
    public Dev(int age){
        this.age = age;
        System.out.println("parameterize constructor");
    }
    public Dev(int age, int salary){
        this.age = age;
        this.salary = salary;
        System.out.println("the 2nd parameterized Constructor is being called.");
    }

    public void build(){
        laptop.compile(); // laptop will be injected
        System.out.println("building");
    }
}
