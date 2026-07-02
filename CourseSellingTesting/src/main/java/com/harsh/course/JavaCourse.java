package com.harsh.course;

public class JavaCourse implements Course{

    @Override
    public boolean coursePurchased() {
        System.out.println("Java Course Purchased");
        return true;
    }
}
