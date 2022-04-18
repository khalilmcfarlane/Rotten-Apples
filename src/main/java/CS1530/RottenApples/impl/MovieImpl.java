package CS1530.RottenApples.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import CS1530.RottenApples.repositories.MovieRepository;
import CS1530.RottenApples.models.Movie;

public class MovieImpl {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> listAllMovies(String regex) {
        if(regex != null) {
            return movieRepository.findMovieRegex(regex);
        }
        return movieRepository.findAll();
    }
}
