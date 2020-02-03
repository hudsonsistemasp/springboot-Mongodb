package com.mongdb.mongodbTest.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongdb.mongodbTest.domain.Post;
import com.mongdb.mongodbTest.repository.PostRepository;
import com.mongdb.mongodbTest.service.exception.ObjectNotFoundException;

@Service
public class PostService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id){
		Optional<Post> posts = postRepository.findById(id);
		return posts.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
	}
	
	//Consulta utilizando o JPA
	public List<Post> findByTitleContaining(String text){
		return postRepository.findByTitleContaining(text);
	}
	
	//Consulta personalizada usando @Query - Isso é do mongodb e não do Java
	public List<Post> serchTitleByRegexCaseInsentive(String text){
		List<Post> list = postRepository.serarchTitle(text);
		return list;
	}
	
}
