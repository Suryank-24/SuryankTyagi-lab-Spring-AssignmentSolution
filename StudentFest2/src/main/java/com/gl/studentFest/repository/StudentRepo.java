package com.gl.studentFest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.studentFest.entity.Student;


@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
	
	List<Student> findByNameContainsAndCountryContainsAllIgnoreCase(String name, String country);


}
