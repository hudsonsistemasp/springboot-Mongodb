package com.mongdb.mongodbTest.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongdb.mongodbTest.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{


}
