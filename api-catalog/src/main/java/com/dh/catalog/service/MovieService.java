package com.dh.catalog.service;

import com.dh.catalog.client.*;
import com.dh.catalog.model.DTO.*;
import  java.lang.Throwable;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MovieService {

    private MovieFeign movieFeign;

    public MovieService(MovieFeign movieFeign) {
        this.movieFeign = movieFeign;
    }

    public List<MovieDTO> getAll(){
        return movieFeign.getMovie();
    }

    @CircuitBreaker(name = "movieClient",fallbackMethod = "movieFallback")
    @Retry(name = "movieClient")
    public List<MovieDTO> getAllMovieByGenre(String genre){
        log.info("Consulto movie por género");
        return movieFeign.getMoviesByGenre(genre);
    }

    public MovieDTO saveMovie(MovieDTO movie){
        log.info("Guardo movie por género");
        return movieFeign.saveMovie(movie);
    }

    private List<MovieDTO> movieFallback(Throwable t){
        log.error("Error MS Movie: ", t.getMessage());
        return new ArrayList<>();
    }
}