package com.gl.studentFest.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.studentFest.entity.Student;
import com.gl.studentFest.repository.StudentRepo;
import com.gl.studentFest.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepo studentRepo;
	
	
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		List<Student> students = studentRepo.findAll();
		return students;
	}

	@Override
	public Student findById(int theId) {
		// TODO Auto-generated method stub
		Student student = studentRepo.findById(theId).get();
		return student;
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentRepo.save(student);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		studentRepo.deleteById(theId);
	}

	@Override
	public List<Student> searchBy(String name, String country) {
		// TODO Auto-generated method stub
		List<Student> students = studentRepo.findByNameContainsAndCountryContainsAllIgnoreCase(name, country);
		return students;
	}

}
