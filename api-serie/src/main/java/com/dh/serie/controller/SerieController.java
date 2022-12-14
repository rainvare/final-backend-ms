package com.dh.serie.controller;
import com.dh.serie.model.Serie;
import com.dh.serie.service.SerieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/series")
public class SerieController {

    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }
// Busco por género
    @GetMapping("/{genre}")
    public ResponseEntity<List<Serie>> getSeriesByGenre(@PathVariable String genre){
        return ResponseEntity.ok().body(serieService.getByGenre(genre));
    }
// Busco por id
    @GetMapping("/find/serie/{id}")
    public ResponseEntity<Serie> getSerieById(@PathVariable Long id){
        return ResponseEntity.ok().body(serieService.getSerieById(id));
    }
// Guardo
    @PostMapping("/save")
    public ResponseEntity<Serie> saveSerie(@RequestBody Serie serie){
        return ResponseEntity.ok().body(serieService.save(serie));
    }

// Actualizo
    @PutMapping
    public ResponseEntity<Serie>  updateSerie(@RequestBody Serie serie) {
        serieService.updateSerie(serie);
        return ResponseEntity.ok().build();
    }

// Borro por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Serie> deleteSerie(@PathVariable Long id){
        serieService.deleteSerie(id);
        return ResponseEntity.ok().build();
    }

// Listo todo
    @GetMapping()
    public ResponseEntity<List<Serie>> getAll(){
        return ResponseEntity.ok(serieService.getAllSeries());
    }


}
