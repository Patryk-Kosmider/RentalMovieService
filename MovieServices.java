package com.example.MovieService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class MovieServices {

   private final MovieRepository movieRepository;

   public MovieServices(MovieRepository movieRepository){
       this.movieRepository = movieRepository;
   }

   public Movie findById(int id) throws MovieNotFoundException {
       return movieRepository.findById(id)
               .orElseThrow(MovieNotFoundException::new);
   }

   public List<Movie> getAll(){
       return movieRepository.findAll();
   }

   public void deleteMovieById(int id){
       movieRepository.deleteById(id);
   }

   public Movie addNewMovie(Movie movie){
      return movieRepository.save(movie);
   }

   public Movie updateMovie(Movie movie, int id){
       Optional<Movie> movie_found = movieRepository.findById(id);
       if(movie_found.isPresent()){
           movieRepository.save(movie);
       }
       return movie;
   }

   public Movie updateIsAvailable(int id) throws MovieNotFoundException {
       Movie movie = findById(id);
       movie.setIs_available(true);
       return movieRepository.save(movie);
   }


}
