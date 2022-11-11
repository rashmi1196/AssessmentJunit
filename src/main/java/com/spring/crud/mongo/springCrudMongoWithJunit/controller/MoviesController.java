package com.spring.crud.mongo.springCrudMongoWithJunit.controller;

import com.spring.crud.mongo.springCrudMongoWithJunit.model.Movie;
import com.spring.crud.mongo.springCrudMongoWithJunit.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    MovieService movieService;


    @GetMapping
    public List<Movie> findAllMovie(){
        return movieService.findAllMovies();
    }

    @PostMapping
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
        movieService.saveMovie(movie);
         return new ResponseEntity<>("Movie added successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable("id") String id,@RequestBody Movie movie){
        movieService.saveMovie(movie);
        return new ResponseEntity<>("Movie updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovieById(@PathVariable("id") String id){
        movieService.deleteByMovieId(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }


}
