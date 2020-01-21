package com.mongdb.mongodbTest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongdb.mongodbTest.domain.User;
import com.mongdb.mongodbTest.repository.UserRepository;
import com.mongdb.mongodbTest.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		List<User> user = userRepository.findAll();
		return user;
	}
	
	public User findById(String id) {
		Optional<User> objUser = userRepository.findById(id);
		return objUser.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	}
	
}
