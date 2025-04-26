package com.spring.journalapp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.journalapp.entity.User;

public interface UserRepo extends MongoRepository<User, ObjectId>{

    User findByUserName(String username);

    
}
