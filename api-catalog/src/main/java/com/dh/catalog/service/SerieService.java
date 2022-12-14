package com.dh.catalog.service;

import com.dh.catalog.client.*;
import com.dh.catalog.model.DTO.*;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SerieService {

    private SerieFeign serieFeign;

    public SerieService(SerieFeign serieFeign) {
        this.serieFeign = serieFeign;
    }

    public List<SerieDTO> getAll(){
        return serieFeign.getSerie();
    }

    @CircuitBreaker(name = "serieClient",fallbackMethod = "serieFallback")
    @Retry(name = "serieClient")
    public List<SerieDTO> getAllSeriesByGenre(String genre){
        log.info("Consulto serie por género");
        return serieFeign.getSeriesByGenre(genre);
    }

    public SerieDTO saveSerie(SerieDTO serie){
        log.info("Guardo serie por género");
        return serieFeign.saveSerie(serie);
    }

    private List<SerieDTO> serieFallback(Throwable t){
        log.error("Error MS Serie: ", t.getMessage());
        return new ArrayList<>();
    }
}