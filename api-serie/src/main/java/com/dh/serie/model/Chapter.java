package com.dh.serie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serial;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chapter{

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    private Long chapterId;
    private String name;
    private Integer chapterNumber;
    private String urlStream;
}
