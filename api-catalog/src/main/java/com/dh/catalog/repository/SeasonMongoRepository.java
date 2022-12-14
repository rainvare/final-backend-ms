package com.dh.catalog.repository;

import com.dh.catalog.model.Season;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonMongoRepository extends MongoRepository<Season, Long> {
}
