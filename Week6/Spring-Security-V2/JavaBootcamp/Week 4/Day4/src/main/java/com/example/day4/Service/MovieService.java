package com.example.day4.Service;

import com.example.day4.Exception.ApiException;
import com.example.day4.Model.Movie;
import com.example.day4.Repository.DirectorRepository;
import com.example.day4.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    
    private final MovieRepository movieRepository;
    private final DirectorService directorService;

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }

    public void updateMovie(Integer id, Movie movie){
        Movie oldMovie = movieRepository.findById(id).orElse(null);

        if(oldMovie == null)
            throw new ApiException("ID not found");


        movieRepository.save(oldMovie);
    }

    public void deleteMovie(Integer id){
        Movie movie = movieRepository.findById(id).orElse(null);

        if (movie == null){
            throw new ApiException("ID not found");
        }

        movieRepository.delete(movie);
    }

    public Movie findMovieByName(String name){
        Movie movie = movieRepository.findMovieByName(name);
        if (movie == null){
            throw new ApiException("Name of the movie was not found");
        }
        return movie;
    }

    public int findMovieDuration(String name){
        Movie movie = movieRepository.findMovieByName(name);
        if (movie == null){
            throw new ApiException("Name of the movie was not found");
        }
        return movie.getDuration();
    }

    public String findMovieDirector(String name){
        Movie movie = movieRepository.findMovieByName(name);
        if (movie == null){
            throw new ApiException("Name of the movie was not found");
        }
        String directorName = directorService.getDirectorName(movie.getDirectorId());
        return directorName;
    }

    public List<Movie> findMoviesByDirector(String name){
        Integer directorId = directorService.getDirectorID(name);

        List<Movie> movies = movieRepository.findMoviesByDirectorId(directorId);

        if (movies.isEmpty())
            throw new ApiException("The Director: " + name +" has no movies");

        return movies;

    }

    public int findMovieRate(String name){
        Movie movie = movieRepository.findMovieByName(name);
        if (movie == null){
            throw new ApiException("Name of the movie was not found");
        }
        return movie.getRating();
    }

    public List<Movie> findMoviesByRate(int rate){
        List<Movie> movies = movieRepository.findMovieByRatingIsGreaterThanEqual(rate);

        if(movies.isEmpty())
            throw new ApiException("There are no movies above or equal the rating: " + rate);

        return movies;
    }

    public List<Movie> findMoviesByGenre(String genre){
        List<Movie> movies = movieRepository.findMoviesByGenre(genre);

        if(movies.isEmpty())
            throw new ApiException("There are no movies that has the genre: " + genre);

        return movies;
    }


}
