package com.gl.studentFest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gl.studentFest.entity.User;


public interface UserRepo  extends JpaRepository<User, Long> {
	
	@Query("select u from User u where u.username = ?1")
	public User getUserByUserName(String username); 

	}

