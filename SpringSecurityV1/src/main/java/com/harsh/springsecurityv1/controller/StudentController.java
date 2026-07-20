package com.harsh.springsecurityv1.controller;

import com.harsh.springsecurityv1.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Navin", 60),
            new Student(2, "Harsh", 95),
            new Student(3, "Priya", 88),
            new Student(4, "Rahul", 72),
            new Student(5, "Ananya", 91),
            new Student(6, "Rohan", 67),
            new Student(7, "Sneha", 84),
            new Student(8, "Amit", 78),
            new Student(9, "Karan", 55),
            new Student(10, "Neha", 98)
    ));

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }


    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
