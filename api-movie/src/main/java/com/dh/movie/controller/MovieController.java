package com.dh.movie.controller;

import com.dh.movie.model.Movie;
import com.dh.movie.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

// Busco por género
    @GetMapping("/{genre}")
    public ResponseEntity<List<Movie>> findMovieByGenre(@PathVariable String genre) throws Exception {
        return ResponseEntity.ok().body(movieService.getByGenre(genre));
    }
// Busco por id
    @GetMapping("/find/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        return ResponseEntity.ok().body(movieService.getMovieById(id));
    }
// Guardo
    @PostMapping("/save")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok().body(movieService.save(movie));
    }
// Actualizo
    @PutMapping
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
        movieService.updateMovie(movie);
        return ResponseEntity.ok().build();
    }

//Borro
    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok().build();
    }
// Listo todo
    @GetMapping
        public ResponseEntity<List<Movie>> getAllMovies(){
            return ResponseEntity.ok(movieService.getAllMovies());
        }
}
