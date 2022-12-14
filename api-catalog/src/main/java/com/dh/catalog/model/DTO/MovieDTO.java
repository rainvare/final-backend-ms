package com.dh.catalog.model.DTO;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO implements Serializable {
    private Integer movieId;
    private String name;
    private String genre;
    private String urlStream;

    public Integer getId() { return movieId; }
    public void setId(Integer movieId) { this.movieId = movieId; }

    public String getMovieName() { return name; }
    public void setMovieName(String name) { this.name = name; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getUrlStream() { return urlStream; }
    public void setUrlStream(String urlStream) { this.urlStream = urlStream; }

    @Override
    public String toString() {
        return "MovieDTO {"
                + "id = " + movieId
                + ", title = " + name + '\''
                + ", genre = " + genre + '\''
                + ", urlStream = " +urlStream + '\''
                + "}";
    }
}
