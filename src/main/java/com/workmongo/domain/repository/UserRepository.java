package com.workmongo.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.workmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

}
