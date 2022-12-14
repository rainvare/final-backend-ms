package com.dh.catalog.client;

import com.dh.catalog.model.DTO.SerieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import com.dh.catalog.config.*;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

// configuro también el loadbalancer
@FeignClient(name="api-serie")
@LoadBalancerClient(name = "api-serie", configuration= LoadBalancer.class)
public interface SerieFeign {

    @GetMapping("/api/v1/series/{genre}")
    List<SerieDTO> getSeriesByGenre(@PathVariable (value = "genre") String genre);

    @PostMapping("/api/v1/series/save")
    SerieDTO saveSerie(@RequestBody SerieDTO serie);

    @GetMapping("/api/v1/series/all")
    List<SerieDTO> getSerie();

}
