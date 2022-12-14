package com.dh.catalog.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Catalog {

    @Id
    private String genre;
    private List<Movie> movies;
    private List<Serie> series;


    public Catalog(String genre, List<Movie> movies, List<Serie> series) {
        this.genre = genre;
        this.movies = movies;
        this.series = series;
    }
}
