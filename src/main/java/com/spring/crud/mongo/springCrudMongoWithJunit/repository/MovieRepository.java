package com.spring.crud.mongo.springCrudMongoWithJunit.repository;

import com.spring.crud.mongo.springCrudMongoWithJunit.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

}
