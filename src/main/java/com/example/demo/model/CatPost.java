package com.example.demo.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class CatPost {
    long id;
    long authorId;
    String description;
    String photoUrl;
    String creationDate;

    public CatPost(long authorId, String description, String photoUrl, String creationDate) {
        this.authorId = authorId;
        this.description = description;
        this.photoUrl = photoUrl;
        this.creationDate = creationDate;
    }
}
