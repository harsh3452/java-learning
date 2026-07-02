package com.harsh.service;
import com.harsh.course.Course;
public class PurchaseCourse {
    private Course course;
    public boolean proceedWithCourse(Course course){
        return course.coursePurchased();
    }
}
