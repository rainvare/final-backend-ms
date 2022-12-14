package com.dh.catalog.model;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serial;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chapter {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String chapterId;
    private String name;
    private Integer chapterNumber;
    private String urlStream;
}