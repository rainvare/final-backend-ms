package com.dh.catalog.repository;
import com.dh.catalog.model.Chapter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterMongoRepository extends MongoRepository<Chapter, Long> {
}
