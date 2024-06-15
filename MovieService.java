package com.example.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieService {
/*
    private final MovieStorage movieStorage;

    public MovieService(MovieStorage movieStorage) throws MovieNoIdGivenException {
        this.movieStorage = movieStorage;

        Movie m1 = new Movie("ABC01", "Testowy film", "kategoria");
        Movie m2 = new Movie("DEF01", "Kubus Puchatek", "bajka");
        movieStorage.addMovie(m1);
        movieStorage.addMovie(m2);

    }

    public List<Movie> getMovieList() {
        return movieStorage.getMovieList();
    }

    public Movie getMovieByID(String id) throws MovieNotFoundException {
        for (Movie movie : movieStorage.getMovieList()) {
            if (movie.getID().equals(id)) {
                return movie;
            }
        }
        throw new MovieNotFoundException("Movie not found");
    }

    public void addNewMovie(Movie movie){
        movieStorage.addMovie(movie);
    }

    public void deleteMovie(String id) throws MovieNotFoundException{
        for (Movie movie: movieStorage.getMovieList()){
            if(movie.getID().equals(id)){
                movieStorage.getMovieList().remove(movie);
            }
        }
        throw new MovieNotFoundException("Movie not found");
    }

 */
}
