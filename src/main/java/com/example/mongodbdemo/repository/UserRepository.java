package com.example.mongodbdemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongodbdemo.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}
