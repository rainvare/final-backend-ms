package com.dh.catalog.repository;
import com.dh.catalog.model.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface CatalogRepository extends MongoRepository<Catalog, String> {
    Optional<Catalog> findByGenre(String genre);
    void deleteByGenre(String genre);
}

