package com.dh.catalog.model;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Season implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    @Id
    private String seasonId;
    private Integer seasonNumber;
    private List<Chapter> chapters;
}