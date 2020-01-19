package com.mongdb.mongodbTest.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mongdb.mongodbTest.domain.User;
import com.mongdb.mongodbTest.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		User sorina = new User(null, "Sorina Lima", "sorina@email.com");
		User phanton = new User(null, "Phanton Polo","polo@email.com.br");
		User gerrad = new User(null, "Gerrad Southl", "gerrad@email.com");
		User norran = new User(null, "Norran Feill", "nor@email.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob,sorina,phanton,gerrad,norran));
		
	}

}
