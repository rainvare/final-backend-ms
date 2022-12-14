package com.dh.serie.service;
import com.dh.serie.event.NewSerieEventProducer;
import com.dh.serie.model.Serie;
import com.dh.serie.repository.SerieRepository;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    final static Logger log = Logger.getLogger(SerieService.class);
    private final SerieRepository serieRepository;
    private final NewSerieEventProducer newSerieEventProducer;

    public SerieService(SerieRepository serieRepository, NewSerieEventProducer newSerieEventProducer) {
        this.serieRepository = serieRepository;
        this.newSerieEventProducer = newSerieEventProducer;
    }

// Métodos y logs de Series

    public List<Serie> getAllSeries(){
        List<Serie> allSeries = serieRepository.findAll();
        log.info("Todas las series");
        return allSeries;
    }

    public Serie getSerieById(Long id) {
        log.info("Serie con el id: " + id);
        return serieRepository.findById(id).orElse(null);
    }

    public List<Serie> getByGenre(String genre){
        List<Serie> series = serieRepository.findByGenre(genre);
        log.info("Busco serie por género: " + genre);
        return series;

    }

    public Serie save(Serie serie){
        serieRepository.save(serie);
        newSerieEventProducer.execute(serie);
        log.info("Guardo la serie: " + serie.getName());
        return serie;
    }

    public void deleteSerie(Long id){
        log.info("Borro la serie id: " + id);
        serieRepository.deleteById(id);
    }

    public void updateSerie(Serie serie){
        if(serieRepository.existsById(serie.getSerieId())){
            log.info("Actualizo la serie con el id: " + serie.getSerieId());
            serieRepository.save(serie);
        }
    }

}
