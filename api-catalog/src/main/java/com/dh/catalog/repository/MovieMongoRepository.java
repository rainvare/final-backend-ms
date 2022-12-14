package com.dh.catalog.repository;
import com.dh.catalog.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieMongoRepository extends MongoRepository<Movie, Long> {
    List<Movie> findByGenre(String genre);
}
