package com.mongdb.mongodbTest.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mongdb.mongodbTest.domain.Post;
import com.mongdb.mongodbTest.domain.User;
import com.mongdb.mongodbTest.dto.AuthorDTO;
import com.mongdb.mongodbTest.dto.CommentsDTO;
import com.mongdb.mongodbTest.repository.PostRepository;
import com.mongdb.mongodbTest.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com","senha1");
		User alex = new User(null, "Alex Green", "alex@gmail.com","senha2");
		User bob = new User(null, "Bob Grey", "bob@gmail.com","senha3");
		User sorina = new User(null, "Sorina Lima", "sorina@email.com","senha4");
		User phanton = new User(null, "Phanton Polo","polo@email.com.br","senha5");
		User gerrad = new User(null, "Gerrad Southl", "gerrad@email.com","senha6");
		User norran = new User(null, "Norran Feill", "nor@email.com","senha7");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob,sorina,phanton,gerrad,norran));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		
		/* Antes de gerar o DTO instanciava e persistia o objeto USER assim, mas não queremos passar todos os dados do USER, principalmente SENHA
		Post post1 = new Post(null, sdf.parse("2018/03/21"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("2018/03/23"), "Bom dia", "Acordei feliz hoje!", maria);
		*/
		
		
		/* 1° MANEIRA com DTO
		AuthorDTO mariaDTO = new AuthorDTO(maria.getId(), maria.getName(), maria.getEmail());
		
		Post post1 = new Post(null, sdf.parse("2018/03/21"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", mariaDTO);
		Post post2 = new Post(null, sdf.parse("2018/03/23"), "Bom dia", "Acordei feliz hoje!", mariaDTO);
		*/
		
		/*2° MANEIRA com DTO*/
		AuthorDTO mariaDTO = new AuthorDTO(maria);
		Post post1 = new Post(null, sdf.parse("2018/03/21"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", mariaDTO);
		Post post2 = new Post(null, sdf.parse("2018/03/23"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		//3-Associar todos comentários de um User a ele
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
		//Criar os comentários para associar aos posts
		
		CommentsDTO comment1 = new CommentsDTO("Boa viagem mano!", sdf.parse("2018/03/21"), new AuthorDTO(alex));
		CommentsDTO comment2 = new CommentsDTO("Aproveite!", sdf.parse("2018/03/22"), new AuthorDTO(bob));
		CommentsDTO comment3 = new CommentsDTO("Tenha um ótimo dia!", sdf.parse("2018/03/23"), new AuthorDTO(alex));
		
		post1.setComments(Arrays.asList(comment1,comment2));
		post2.setComments(Arrays.asList(comment3));
		/*
		post1.getComments().addAll(Arrays.asList(comment1, comment2));
		post2.getComments().addAll(Arrays.asList(comment3));
		*/
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		
	}

}
