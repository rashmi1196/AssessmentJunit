package com.spring.crud.mongo.springCrudMongoWithJunit.service;

import com.spring.crud.mongo.springCrudMongoWithJunit.model.Movie;
import com.spring.crud.mongo.springCrudMongoWithJunit.repository.MovieRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MovieServiceTest {
    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieServiceImplementation service;

    @Before
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }



    @Test
    public void getAllMovies(){
        List<Movie> movieList = new ArrayList<Movie>();
        movieList.add(new Movie("1", "Star Wars",4 ));
        movieList.add(new Movie("2", "Iron Man",5));
        movieList.add(new Movie("3", "Avengers",5));


        when(movieRepository.findAll()).thenReturn(movieList);

        List<Movie> movieResult = service.findAllMovies();

        assertEquals(3, movieResult.size());
    }




    @Test
    public void saveMovie(){

        Movie movie = new Movie("1", "Resident Evil",4);

        when(movieRepository.save(movie)).thenReturn(movie);

        Movie movieResult = service.saveMovie(movie);

        assertEquals("1", movieResult.getId());
        assertEquals("Resident Evil", movieResult.getName());
        assertEquals(4, movieResult.getRating());
    }

    @Test
    public void deleteMovieById(){

        Movie movie = new Movie("1", "Resident Evil",4);

        service.deleteByMovieId(movie.getId());

        verify(movieRepository, times(1)).deleteById(movie.getId());

    }


}
