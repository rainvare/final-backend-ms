package com.dh.serie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Season implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    @Id
    private Long seasonId;
    private Integer seasonNumber;
    private List<Chapter> chapters;
}
