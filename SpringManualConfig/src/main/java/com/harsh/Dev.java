package com.harsh;

public class Dev {

    private Computer computer;

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
        System.out.println("Using setter for injection");
    }
    public Dev(){
        System.out.println("Dev Constructor default no parameters");
    }
    public Dev(Computer computer){
        this.computer = computer;
        System.out.println("Dev Constructor with computer object, it can be laptop or desktop, check further output");
        System.out.println("constructor injection for computer");
    }

    public void build(){
        computer.compile();
        System.out.println(" Dev build app");
    }
}
