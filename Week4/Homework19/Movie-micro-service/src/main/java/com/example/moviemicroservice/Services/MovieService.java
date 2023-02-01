package com.example.moviemicroservice.Services;

import com.example.moviemicroservice.Exception.ApiException;
import com.example.moviemicroservice.Models.Director;
import com.example.moviemicroservice.Models.Movie;
import com.example.moviemicroservice.Models.MovieDirector;
import com.example.moviemicroservice.Repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final RestTemplate restTemplate = new RestTemplate();


    public List<MovieDirector> getAll(){

        List<Movie> movies = movieRepository.findAll();
        List<MovieDirector> movieDirectors = new ArrayList<>();
        for (Movie m: movies
             ) {
            Director director=null;
            try {
                director = restTemplate.getForObject("http://localhost:8082/api/v1/director/get/id/"+m.getDirectorId(), Director.class);
            }catch (HttpClientErrorException e){

            }
            movieDirectors.add(new MovieDirector(m,director));
            System.out.println(director);
        }
        return movieDirectors;
    }

    public void addMovie(Movie movie){
        Director director=null;
        try {
            director = restTemplate.getForObject("http://localhost:8082/api/v1/director/get/id/"+movie.getDirectorId(), Director.class);
        }catch (HttpClientErrorException e){
            throw new ApiException("Director with given id not found!",400);
        }
        movieRepository.save(movie);
    }

    public Movie findById(Integer id){
        Movie movie =movieRepository.findMovieById(id);
        if(movie==null){
            throw new ApiException("Movie not found",404);
        }
        return movie;
    }



    public void updateMovie(Integer id, Movie movie){
        Movie oldMovie = movieRepository.findMovieById(id);
        Director director=null;
        try {
            director = restTemplate.getForObject("http://localhost:8082/api/v1/director/get/id/"+movie.getDirectorId(), Director.class);
        }catch (HttpClientErrorException e){
            throw new ApiException("Director with given id not found!",400);
        }
        if(oldMovie ==null){
            throw new ApiException("User not found!",404);
        }
        movie.setId(id);
        movieRepository.save(movie);
    }

    public void deleteMovie(Integer id){
        Movie movie = movieRepository.findMovieById(id);
        if(movie ==null){
            throw new ApiException("Movie not found!",404);
        }
        movieRepository.delete(movie);
    }


    public List<MovieDirector> getMoviesByDirector(Integer directorId){
        List<Movie> movies = movieRepository.findMoviesByDirectorId(directorId);
        List<MovieDirector> movieDirectors = new ArrayList<>();
        for (Movie m: movies
        ) {
            Director director=null;
            try {
                director = restTemplate.getForObject("http://localhost:8082/api/v1/director/get/id/"+m.getDirectorId(), Director.class);
            }catch (HttpClientErrorException e){

            }
            movieDirectors.add(new MovieDirector(m,director));
            System.out.println(director);
        }
        if(movies.isEmpty()){
            throw new ApiException("No movies found with director id provided! ",404);
        }
        return movieDirectors;
    }
    public List<MovieDirector> getMoviesByRating(Integer rating){
        List<Movie> movies = movieRepository.findMoviesByRatingGreaterThanEqual(rating);
        List<MovieDirector> movieDirectors = new ArrayList<>();
        for (Movie m: movies
        ) {
            Director director=null;
            try {
                director = restTemplate.getForObject("http://localhost:8082/api/v1/director/get/id/"+m.getDirectorId(), Director.class);
            }catch (HttpClientErrorException e){

            }
            movieDirectors.add(new MovieDirector(m,director));
            System.out.println(director);
        }
        if(movies.isEmpty()){
            throw new ApiException("No movies found with rating provided! ",404);
        }
        return movieDirectors;
    }

    public List<MovieDirector> getByMoviesName(String name){
        List<Movie> movies = movieRepository.findMoviesByNameIsLike(name);
        List<MovieDirector> movieDirectors = new ArrayList<>();
        for (Movie m: movies
        ) {
            Director director=null;
            try {
                director = restTemplate.getForObject("http://localhost:8082/api/v1/director/get/id/"+m.getDirectorId(), Director.class);
            }catch (HttpClientErrorException e){

            }
            movieDirectors.add(new MovieDirector(m,director));
            System.out.println(director);
        }
        if(movies.isEmpty()){
            throw new ApiException("No movies found with name provided! ",404);
        }
        return movieDirectors;
    }

    public Integer getDurationByName(String name){
        Movie movie = movieRepository.findMovieByName(name);

        if(movie == null){
            throw new ApiException("No movies found with name provided! ",404);
        }
        return movie.getDuration();
    }

    public String getDirectorName(String name){
        Movie movie = movieRepository.findMovieByName(name);
        Director director=null;
        try {
            director = restTemplate.getForObject("http://localhost:8082/api/v1/director/get/id/"+movie.getDirectorId(), Director.class);
        }catch (HttpClientErrorException e){
            throw new ApiException("Director with given id not found!",400);
        }
        if(movie == null){
            throw new ApiException("No movies found with name provided! ",404);
        }
        return director.getName();
    }

    public Integer getRate(String name){
        Movie movie = movieRepository.findMovieByName(name);
        if(movie == null){
            throw new ApiException("No movies found with name provided! ",404);
        }
        return movie.getRating();
    }

    public List<MovieDirector> getMoviesAboveRating(Integer rating){
        List<Movie> movies = movieRepository.findMoviesByRatingGreaterThan(rating);
        List<MovieDirector> movieDirectors = new ArrayList<>();
        for (Movie m: movies
        ) {
            Director director=null;
            try {
                director = restTemplate.getForObject("http://localhost:8082/api/v1/director/get/id/"+m.getDirectorId(), Director.class);
            }catch (HttpClientErrorException e){

            }
            movieDirectors.add(new MovieDirector(m,director));
            System.out.println(director);
        }
        if(movies.isEmpty()){
            throw new ApiException("No movies found with rating provided! ",404);
        }
        return movieDirectors;
    }

    public List<MovieDirector> getMoviesByGenre(String genre){
        List<Movie> movies = movieRepository.findMoviesByGenre(genre);
        List<MovieDirector> movieDirectors = new ArrayList<>();
        for (Movie m: movies
        ) {
            Director director=null;
            try {
                director = restTemplate.getForObject("http://localhost:8082/api/v1/director/get/id/"+m.getDirectorId(), Director.class);
            }catch (HttpClientErrorException e){

            }
            movieDirectors.add(new MovieDirector(m,director));
            System.out.println(director);
        }
        if(movies.isEmpty()){
            throw new ApiException("No movies found with rating provided! ",404);
        }
        return movieDirectors;
    }


}
