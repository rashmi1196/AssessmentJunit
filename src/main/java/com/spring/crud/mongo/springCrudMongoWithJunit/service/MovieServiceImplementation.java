package com.spring.crud.mongo.springCrudMongoWithJunit.service;

import com.spring.crud.mongo.springCrudMongoWithJunit.model.Movie;
import com.spring.crud.mongo.springCrudMongoWithJunit.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieServiceImplementation implements MovieService {

    MovieRepository movieRepository;

    @Autowired
    public MovieServiceImplementation(MovieRepository userRepository){
        this.movieRepository=movieRepository;
    }

    @Override
    public void deleteByMovieId(String id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie updateMovie(Movie movie) {
      return movieRepository.save(movie);
    }


}
