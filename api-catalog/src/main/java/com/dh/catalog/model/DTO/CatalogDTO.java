package com.dh.catalog.model.DTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CatalogDTO {
    private String genre;
    private List<MovieDTO> movies;
    private List<SerieDTO> series;

    public CatalogDTO(String genre, List<MovieDTO> movies, List<SerieDTO> series) {
        this.genre = genre;
        this.movies = movies;
        this.series = series;
    }
}
