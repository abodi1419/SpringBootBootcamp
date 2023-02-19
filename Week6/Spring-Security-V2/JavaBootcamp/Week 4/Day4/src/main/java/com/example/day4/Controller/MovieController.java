package com.example.day4.Controller;

import com.example.day4.Model.Movie;
import com.example.day4.Service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;


    @GetMapping("/get")
    public ResponseEntity getMovies(){
        return ResponseEntity.status(200).body(movieService.getMovies());
    }

    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid @RequestBody Movie movie){
        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("Movie Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMovie(@PathVariable Integer id, @Valid @RequestBody Movie movie){
        movieService.updateMovie(id,movie);
        return ResponseEntity.status(200).body("Movie Updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id){
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("Movie was deleted");

    }

    @GetMapping("/get/movie/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){
        Movie movie = movieService.findMovieByName(name);
        return ResponseEntity.status(200).body(movie);
    }

    @GetMapping("/get/movie/duration/{name}")
    public ResponseEntity getMovieDuration(@PathVariable String name){
        int duration = movieService.findMovieDuration(name);
        return ResponseEntity.status(200).body("The movie: "+ name + " duration is "+duration+ " minutes");
    }

    @GetMapping("/get/movie/director/{name}")
    public ResponseEntity getMovieDirector(@PathVariable String name){
        String director = movieService.findMovieDirector(name);
        return ResponseEntity.status(200).body("The director of the movie: "+ name + "  is "+ director);
    }

    @GetMapping("/get/movies/director/{name}")
    public ResponseEntity getMoviesByDirector(@PathVariable String name){
        List<Movie> movies = movieService.findMoviesByDirector(name);
        return ResponseEntity.status(200).body(movies);
    }

    @GetMapping("/get/movie/rate/{name}")
    public ResponseEntity GetMovieRate(@PathVariable String name){
        int rate = movieService.findMovieRate(name);
        return ResponseEntity.status(200).body("The Movie: " + name + " has the rating " + rate + " out of 5");
    }

    @GetMapping("/get/movies/above-rate/{rate}")
    public ResponseEntity getMoviesAboveRate(@PathVariable int rate){
        List<Movie> movies = movieService.findMoviesByRate(rate);
        return ResponseEntity.status(200).body(movies);
    }

    @GetMapping("/get/movies/genre/{genre}")
    public ResponseEntity getMoviesByGenre(@PathVariable String genre){
        List<Movie> movies = movieService.findMoviesByGenre(genre);
        return ResponseEntity.status(200).body(movies);
    }



}
