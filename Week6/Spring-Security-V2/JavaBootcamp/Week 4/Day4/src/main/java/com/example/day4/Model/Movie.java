package com.example.day4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="movie_id_seq", initialValue=100)
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="movie_id_seq")
    private Integer id;

    @NotEmpty(message = "Name is required")
    @Size(min = 2, message = "Name length must be more than 1")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String name;

    @NotEmpty(message = "genre is required")
    @Pattern(regexp = "Drama|Action|Comedy")
    @Column(columnDefinition = "varchar(6) not null")
    private String genre;

    @NotNull(message = "Rating is required")
    @Min(value = 1, message = "Rating must be between 1 to 5")
    @Max(value = 5, message = "Rating must be between 1 to 5")
    @Column(columnDefinition = "int not null check (rating >= 1 and rating <=5)")
    private int rating;

    @NotNull(message = "Duration is required")
    @Min(value = 60, message = "Duration of the movie must be more than 60")
    @Column(columnDefinition = "int not null check (duration >= 60)")
    private int duration;

    @NotNull(message = "Director is required")
    @Min(value = 3, message = "Director id length must be more than 2 digits")
    @Column(columnDefinition = "int not null")
    private Integer directorId;

}
