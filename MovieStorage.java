package com.example.MovieService;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieStorage {
    private List<Movie> movieList;

    public MovieStorage(List<Movie> movieList){
        this.movieList = new ArrayList<>();
    }

    public List<Movie> getMovieList() {
        return movieList;
    }
    public void addMovie(Movie movie){
        movieList.add(movie);
    }
}

