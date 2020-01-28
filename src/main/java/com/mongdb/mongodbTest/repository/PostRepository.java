package com.mongdb.mongodbTest.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongdb.mongodbTest.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
}
