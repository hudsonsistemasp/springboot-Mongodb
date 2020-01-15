package com.mongdb.mongodbTest.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongdb.mongodbTest.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	//@RequestMapping //Funciona a mesma coisa que abaixo
	@RequestMapping(method=RequestMethod.GET)//Isso diz que esse endpoint vai ser um método no caminho citado acima:"/users"
	public ResponseEntity<List<User>> findAll(){
		List<User> list = new ArrayList<>();
		User user1 = new User("1111", "Jonas Brown", "TesteMongoJonas@email.com");
		User user2 = new User("2222", "Maria James", "TesteMongoMaria@email.com");
		list.addAll(Arrays.asList(user1, user2));
		return ResponseEntity.ok().body(list);
	} 
	
}
