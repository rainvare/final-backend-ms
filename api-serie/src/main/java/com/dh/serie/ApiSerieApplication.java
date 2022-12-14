package com.dh.serie;
import com.dh.serie.model.Chapter;
import com.dh.serie.model.Season;
import com.dh.serie.model.Serie;
import com.dh.serie.repository.SerieRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import java.util.ArrayList;

@SpringBootApplication
@EnableDiscoveryClient
@EnableMongoRepositories
public class ApiSerieApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiSerieApplication.class, args);
    }

    @Bean
	public CommandLineRunner loadData(SerieRepository repository){
		return (args) -> {
			if (!repository.findAll().isEmpty()){
				return;
			}

            // Cargo capitulos
			Chapter c1 = new Chapter(1L, "EP1", 1, "www.netflix.com");
			Chapter c2 = new Chapter(2L, "EP2", 2, "www.netflix.com");
			Chapter c3 = new Chapter(3L, "EP3", 3, "www.netflix.com");
            Chapter c4 = new Chapter(4L, "EP4", 3, "www.netflix.com");
            Chapter c5 = new Chapter(5L, "EP5", 3, "www.netflix.com");
            Chapter c6 = new Chapter(6L, "EP6", 3, "www.netflix.com");

			ArrayList<Chapter> listaDeCapitulos = new ArrayList<>();

            // Agrego capitulos

			listaDeCapitulos.add(c1);
			listaDeCapitulos.add(c2);
			listaDeCapitulos.add(c3);
            listaDeCapitulos.add(c4);
            listaDeCapitulos.add(c5);
            listaDeCapitulos.add(c6);


            // Cargo Temporadas
			Season s1 = new Season(1L, 1, listaDeCapitulos);
			Season s2 = new Season(2L, 2, listaDeCapitulos);

			ArrayList<Season> listaDeTemporadas = new ArrayList<>();

            // Agrego Temporadas

			listaDeTemporadas.add(s1);
			listaDeTemporadas.add(s2);

            // Cargo series

			Serie serie1 = new Serie(1L, "serie coreana", "romance", listaDeTemporadas);
			Serie serie2 = new Serie(2L, "serie china", "terror", listaDeTemporadas);
			Serie serie3 = new Serie(3L, "anime", "infantil", listaDeTemporadas);


             // Guardo series

			repository.save(serie1);
			repository.save(serie2);
			repository.save(serie3);
	
		};
	}

}
