package com.example.demo.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class CatPost {
    private Long id;
    private final CatUser author;
    private final LocalDate creationDate;
    private String description;
    private String photoUrl;

    public CatPost(CatUser author, String description, String photoUrl) {
        this.author = author;
        this.description = description;
        this.creationDate = LocalDate.now();
        this.photoUrl = photoUrl;
    }

    public CatPost(Long id, CatUser author, LocalDate creationDate, String description, String photoUrl) {
        this.id = id;
        this.author = author;
        this.creationDate = creationDate;
        this.description = description;
        this.photoUrl = photoUrl;
    }
}
