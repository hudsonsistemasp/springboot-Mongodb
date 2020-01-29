package com.mongdb.mongodbTest.service;

import java.io.Serializable;
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
	
}
