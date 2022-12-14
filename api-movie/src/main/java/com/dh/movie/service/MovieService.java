package com.dh.movie.service;
import com.dh.movie.model.Movie;
import com.dh.movie.event.NewMovieEventProducer;
import com.dh.movie.repository.MovieRepository;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class MovieService {
    
    private final MovieRepository movieRepository;
    private final NewMovieEventProducer newMovieEventProducer;
    final static Logger log = Logger.getLogger(MovieService.class);

    public MovieService(MovieRepository movieRepository, NewMovieEventProducer newMovieEventProducer) {
        this.movieRepository = movieRepository;
        this.newMovieEventProducer = newMovieEventProducer;
    }
// Métodos de Movie y sus logs
    public List<Movie> getAllMovies(){
        log.info("Todas las películas");
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        log.info("Pelicula con el id: " + id);
        return movieRepository.findById(id).orElse(null);
    }

    public List<Movie> getByGenre(String genre) {
        log.info("Todas las películas de género: "+ genre);
        return movieRepository.findByGenre(genre);
    }

    public Movie save(Movie movie) {
        log.info("Guardo la película con nombre: " + movie.getName());
        movieRepository.save(movie);
        newMovieEventProducer.execute(movie);
        return movie;

    }
    public void deleteMovie(Long id){
        log.info("Borro la película con el id:" + id);
        movieRepository.deleteById(id);
    }

    public void updateMovie(Movie movie){
        if(movieRepository.existsById(movie.getId())){
            log.info("Actualizo la película con el id: " + movie.getId());
            movieRepository.save(movie);
        }
    }



}
