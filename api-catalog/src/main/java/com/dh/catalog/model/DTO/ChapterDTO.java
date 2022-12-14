package com.dh.catalog.model.DTO;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChapterDTO implements Serializable{
    private String chapterId;
    private String name;
    private Integer chapterNumber;
    private String urlStream;
    }