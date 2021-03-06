package com.gl.studentFest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.studentFest.entity.Student;

@Service
public interface StudentService {
	
	public List<Student> findAll();
	public Student findById(int theId);
	public void save(Student book);
	public void deleteById(int theId);
	public List<Student> searchBy(String name, String country);

}
