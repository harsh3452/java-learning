package com.harsh.course;

public class SpringBootCourse implements Course{
    @Override
    public boolean coursePurchased(){
        System.out.println("Spring Boot Course Purchased");
        return true;
    }
}

