package com.dh.movie.event;

import com.dh.movie.config.RabbitMQConfig;
import com.dh.movie.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;

@Slf4j
@Component

public class NewMovieEventProducer {

    //implemento las config de Rabbit
    private final RabbitTemplate rabbitTemplate;


    public NewMovieEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void execute(Movie newMovie){
        NewMovieEventProducer.Data data = new NewMovieEventProducer.Data();
        BeanUtils.copyProperties(newMovie, data.getMovie());
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.TOPIC_NEW_MOVIE, data);
    }

    // DTO de MOVIE

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor

    public static class Data implements Serializable{
        @Serial
        private static final long serialVersionUID = 1L;
        private Data.MovieDTO movie = new Data.MovieDTO();

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class MovieDTO implements Serializable{
            @Serial
            private static final long serialVersionUID = 1L;
            private Long id;
            private String name;
            private String genre;
            private String urlStream;
        }

    }
}
