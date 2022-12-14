package com.dh.catalog.event;
import com.dh.catalog.model.Movie;
import com.dh.catalog.config.RabbitMQConfig;
import com.dh.catalog.repository.MovieMongoRepository;
import lombok.*;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import java.io.Serializable;


@Component
public class NewMovieEvent {

    private MovieMongoRepository movieMongoRepository;


    public NewMovieEvent(MovieMongoRepository movieMongoRepository) {
        this.movieMongoRepository = movieMongoRepository;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NEW_MOVIE)
        public void execute(NewMovieEvent.Data data){
            Movie movieNew = new Movie();
            BeanUtils.copyProperties(data.getMovie(), movieNew);
            movieMongoRepository.save(movieNew);


    }

    // DTO Movie
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data implements Serializable {
        private MovieDto movie = new MovieDto();

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class MovieDto {
            private String movieId;
            private String name;
            private String genre;
            private String urlStream;
        }
    }

}

