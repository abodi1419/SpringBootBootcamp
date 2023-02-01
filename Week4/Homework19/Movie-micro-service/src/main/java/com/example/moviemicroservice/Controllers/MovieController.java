package com.example.moviemicroservice.Controllers;

import com.example.moviemicroservice.Models.Movie;
import com.example.moviemicroservice.Services.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/movie")
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/get")
    public ResponseEntity getMovies(){
        return ResponseEntity.status(200).body(movieService.getAll());
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity getMovie(@PathVariable Integer id){
        Movie movie = movieService.findById(id);
        return ResponseEntity.status(200).body(movie);
    }

    @PostMapping("/add")
    public ResponseEntity addMovie(@RequestBody @Valid Movie movie){
        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("Movie added");
    }

    @GetMapping("/get/rating/{rating}")
    public ResponseEntity addUser(@PathVariable Integer rating){
        return ResponseEntity.status(200).body(movieService.getMoviesByRating(rating));
    }

    @GetMapping("/get/rating/above/{rating}")
    public ResponseEntity getMoviesRatingAbove(@PathVariable Integer rating){
        return ResponseEntity.status(200).body(movieService.getMoviesAboveRating(rating));
    }

    @GetMapping("/get/director/{directorId}")
    public ResponseEntity getByDirectorId(@PathVariable Integer directorId){
        return ResponseEntity.status(200).body(movieService.getMoviesByDirector(directorId));
    }

    @GetMapping("/get/title")
    public ResponseEntity getMovieByName(@RequestBody Movie movie){
        return ResponseEntity.status(200).body(movieService.getByMoviesName(movie.getName()));
    }
    @GetMapping("/get/duration")
    public ResponseEntity getDurationByName(@RequestBody Movie movie){
        return ResponseEntity.status(200).body(movieService.getDurationByName(movie.getName()));
    }

    @GetMapping("/get/rating")
    public ResponseEntity getRatingByName(@RequestBody Movie movie){
        return ResponseEntity.status(200).body(movieService.getRate(movie.getName()));
    }

    @GetMapping("/get/genre/{genre}")
    public ResponseEntity getMoviesByGenre(@PathVariable String genre){
        return ResponseEntity.status(200).body(movieService.getMoviesByGenre(genre));
    }

    @GetMapping("/get/director")
    public ResponseEntity getDirectorByName(@RequestBody Movie movie){
        return ResponseEntity.status(200).body(movieService.getDirectorName(movie.getName()));
    }




    @PutMapping("update/{id}")
    public ResponseEntity updateMovie(@PathVariable Integer id, @RequestBody @Valid Movie movie){
        movieService.updateMovie(id, movie);
        return ResponseEntity.status(200).body("Updated successfully");

    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id){
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("Deleted successfully");
    }

}
