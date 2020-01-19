package com.mongdb.mongodbTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongdb.mongodbTest.domain.User;
import com.mongdb.mongodbTest.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		List<User> user = userRepository.findAll();
		return user;
	}
	
}
