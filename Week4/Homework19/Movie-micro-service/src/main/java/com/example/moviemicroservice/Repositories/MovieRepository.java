package com.example.moviemicroservice.Repositories;

import com.example.moviemicroservice.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

//    Movie findMovieByUsername(String username);
    Movie findMovieById(Integer id);
//    Movie findUserByEmail(String email);

//    @Query("select u.username from Movie u where u.id=?1")
//    String findUserName(Integer id);

    @Query("select m from Movie m where m.name like %?1%")
    List<Movie> findMoviesByNameIsLike(String name);

    Movie findMovieByName(String name);

    List<Movie> findMoviesByRatingGreaterThanEqual(Integer rating);
    List<Movie> findMoviesByRatingGreaterThan(Integer rating);
    List<Movie> findMoviesByDirectorId(Integer directorId);

    List<Movie> findMoviesByGenre(String genre);



}