package com.dh.catalog.model.DTO;
import lombok.*;
import java.util.List;
import java.io.Serializable;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SerieDTO implements Serializable{
    private String serieId;
    private String name;
    private String genre;
    private List<SeasonDTO> seasons;
}
