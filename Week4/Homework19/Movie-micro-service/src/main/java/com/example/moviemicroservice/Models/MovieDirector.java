package com.example.moviemicroservice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieDirector {
    Movie movie;
    Director director;

}
