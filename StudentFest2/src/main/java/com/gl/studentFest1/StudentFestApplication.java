package com.gl.studentFest1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.gl.studentFest")
public class StudentFestApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentFestApplication.class, args);
	}

}
