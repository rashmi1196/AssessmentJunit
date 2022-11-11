package com.spring.crud.mongo.springCrudMongoWithJunit.service;

import com.spring.crud.mongo.springCrudMongoWithJunit.model.Movie;

import java.util.List;

public interface MovieService {


    void deleteByMovieId(String id);

    Movie saveMovie(Movie movie);

    List<Movie> findAllMovies();

    Movie updateMovie(Movie movie);


}
