package com.harsh.SpringJDBCH2;

import com.harsh.SpringJDBCH2.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbch2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbch2Application.class, args);
		Student student = context.getBean(Student.class);
		StudentRepo studentRepo = context.getBean(StudentRepo.class);
		student.setId(101);
		student.setName("harsh");
		student.setTech("java");
		studentRepo.save(student);
		System.out.println(studentRepo.findAllStudent());
	}

}
