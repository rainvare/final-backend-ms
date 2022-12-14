package com.dh.catalog.service;

import com.dh.catalog.model.*;
import com.dh.catalog.client.*;
import com.dh.catalog.model.DTO.*;
import com.dh.catalog.service.*;
import com.dh.catalog.repository.*;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import java.util.List.*;
import java.util.ArrayList;

@Service
public class CatalogService{

    private final CatalogRepository catalogRepository;
    private final MovieFeign movieFeign;
    private final SerieFeign serieFeign;
    private final MovieMongoRepository movieMongoRepository;
    private final SerieMongoRepository serieMongoRepository;
    final static Logger logger = Logger.getLogger(CatalogService.class);

    public CatalogService(CatalogRepository catalogRepository, MovieMongoRepository movieMongoRepository, SerieMongoRepository serieMongoRepository, MovieFeign movieFeign, SerieFeign serieFeign) {
        this.catalogRepository = catalogRepository;
        this.movieMongoRepository = movieMongoRepository;
        this.serieMongoRepository = serieMongoRepository;
        this.movieFeign = movieFeign;
        this.serieFeign = serieFeign;
    }

    public Catalog getCatalogFromGenre(String genre){

        List<MovieDTO> movieDTOList = movieFeign.getMoviesByGenre(genre);
        List<SerieDTO> serieDTOList = serieFeign.getSeriesByGenre(genre);

        Catalog response = new Catalog(genre, movieDTOList, serieDTOList);

        Catalog r = catalogRepository.findByGenre(genre).orElse(null);

        if(r != null){
            catalogRepository.deleteByGenre(genre);
        }
        catalogRepository.save(response);

        return response;
    }



    public Catalog saveMovieOnCatalog(MovieDTO movies){
        Catalog r = catalogRepository.findByGenre(movies.getGenre()).orElse(null);
        if(r == null){
            Catalog c = new Catalog(movies.getGenre(), new ArrayList<>(), new ArrayList<>() );
            c.getMovies().add(movies);
            catalogRepository.save(c);
        }

        r.getMovies().add(movies);
        return catalogRepository.save(r);
    }

    public Catalog saveSerieOnCatalog(SerieDTO series){

        Catalog r = catalogRepository.findByGenre(series.getGenre()).orElse(null);

        if(r == null){
            Catalog c = new Catalog(series.getGenre(), new ArrayList<>(), new ArrayList<>() );
            c.getSeries().add(series);
            catalogRepository.save(c);
        }

        r.getSeries().add(series);
        return catalogRepository.save(r);
    }
}