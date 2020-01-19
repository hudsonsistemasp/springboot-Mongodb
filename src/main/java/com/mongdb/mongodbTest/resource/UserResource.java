package com.mongdb.mongodbTest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongdb.mongodbTest.domain.User;
import com.mongdb.mongodbTest.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	//@RequestMapping //Funciona a mesma coisa que abaixo
	@RequestMapping(method=RequestMethod.GET)//Isso diz que esse endpoint vai ser um método no caminho citado acima:"/users"
	public ResponseEntity<List<User>> findAll(){
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	} 
	
}
