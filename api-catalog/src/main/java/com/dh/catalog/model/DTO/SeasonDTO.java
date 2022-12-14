package com.dh.catalog.model.DTO;
import lombok.*;
import java.util.List;
import java.io.Serializable;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeasonDTO implements Serializable{
    private String seasonId;
    private Integer seasonNumber;
    private List<ChapterDTO> chapters;

}
