package com.dh.catalog.controller;
import com.dh.catalog.model.Movie;
import com.dh.catalog.model.Serie;
import com.dh.catalog.service.CatalogService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/catalog")
public class CatalogController {

	private final CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/{genre}")
    public ResponseEntity<?> getCatalogByGenre(@PathVariable String genre) {
        log.info("Catalogo de películas y series con el genero "+ genre);
        return ResponseEntity.ok().body(catalogService.getCatalogFromGenre(genre));
    }

}
