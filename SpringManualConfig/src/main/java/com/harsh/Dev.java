package com.harsh;

public class Dev {

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    private Computer computer;
    private int age;
    private int salary;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
//    public Laptop getLaptop() {
//        return laptop;
//    }
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//        System.out.println("used setter for injection");
//    }
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
//    public Dev(Laptop laptop){
//        this.laptop=laptop;
//        System.out.println("used constructor injection for laptop");
//    }
    public Dev(Computer computer){
        this.computer = computer;
        System.out.println("Dev Constructor with computer object");
        System.out.println("constructor injection for computer");
    }


    public void build(){
        //laptop.compile(); // laptop will be injected
        computer.compile();
        System.out.println("building");
    }
}
