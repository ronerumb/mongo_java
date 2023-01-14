package com.workmongo.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.workmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

}
