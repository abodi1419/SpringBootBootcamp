package com.example.moviemicroservice.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movies")
@Repository
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Name can not be null!")
    @Size(min = 3, max = 60, message = "Name must be between 3 and 60 characters")
    @Column(columnDefinition = "varchar(60) not null")
    private String name;
    @NotNull(message = "Genre can not be null!")
    @Pattern(regexp = "(?:^|\\W)Drama(?:$|\\W)|(?:^|\\W)Action(?:$|\\W)|(?:^|\\W)Comedy(?:$|\\W)", message = "Genre must be Action, Comedy or Drama!")
    @Column(columnDefinition = "varchar(6) check(genre='Drama' or genre='Action' or genre='Comedy')", nullable =false)
    private String genre;
    @NotNull(message = "Rating can not be null!")
    @Min(value = 1, message = "Rating must be between 1 and 5")
    @Max(value = 5, message = "Rating must be between 1 and 5")
    @Column(columnDefinition = "int not null")
    private Integer rating;

    @NotNull(message = "Duration can not be null!")
    @Min(value = 60, message = "Duration must be greater than 60!")
    @Column(columnDefinition = "int not null")
    private Integer duration;

    @NotNull(message = "Director id can not be null!")
    @Min(value = 1, message = "Director id must be greater than 0")
    @Column(columnDefinition = "int not null")
    private Integer directorId;




}


