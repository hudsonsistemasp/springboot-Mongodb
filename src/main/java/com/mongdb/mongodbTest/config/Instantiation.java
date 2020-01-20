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
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com","senha1");
		User alex = new User(null, "Alex Green", "alex@gmail.com","senha2");
		User bob = new User(null, "Bob Grey", "bob@gmail.com","senha3");
		User sorina = new User(null, "Sorina Lima", "sorina@email.com","senha4");
		User phanton = new User(null, "Phanton Polo","polo@email.com.br","senha5");
		User gerrad = new User(null, "Gerrad Southl", "gerrad@email.com","senha6");
		User norran = new User(null, "Norran Feill", "nor@email.com","senha7");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob,sorina,phanton,gerrad,norran));
		
	}

}
