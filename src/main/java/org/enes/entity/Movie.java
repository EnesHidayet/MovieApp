package org.enes.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String language;
    String image;
    String name;
    String country;
    String rating;
    @Column(length = 2048)
    String summary;
    String premiered;
    String url;

    @ElementCollection
    List<Long> genres;

    @ElementCollection
    List<Long> comments;

}
