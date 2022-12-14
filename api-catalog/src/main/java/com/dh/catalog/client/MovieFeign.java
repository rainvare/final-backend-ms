package com.dh.catalog.client;
import com.dh.catalog.model.DTO.MovieDTO;

import org.springframework.cloud.openfeign.FeignClient;
import com.dh.catalog.config.*;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="api-movie")
@LoadBalancerClient(name = "api-movie", configuration= LoadBalancer.class)
public interface MovieFeign {

	@GetMapping("/api/v1/movies/{genre}")
	List<MovieDTO> getMoviesByGenre(@PathVariable (value = "genre") String genre);

	@PostMapping("/api/v1/movies/save")
    MovieDTO saveMovie(@RequestBody MovieDTO movie);

    @GetMapping("/api/v1/movies/all")
    List<MovieDTO> getMovie();
}
