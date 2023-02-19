package com.example.day4.Repository;

import com.example.day4.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    Movie findMovieByName(String name);

    List<Movie> findMoviesByDirectorId(Integer id);

    List<Movie> findMovieByRatingIsGreaterThanEqual(int rate);

    List<Movie> findMoviesByGenre(String genre);

}
