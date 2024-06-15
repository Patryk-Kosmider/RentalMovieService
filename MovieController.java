package com.example.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Movie service", description = "Get movies from database")
@RestController
@RequestMapping("/base")
public class MovieController {


    private final MovieServices movieService;

    public MovieController(MovieServices movieService) {
        this.movieService = movieService;
    }

    @Operation(
            summary = "Retrieve list of all Movies located in database"
    )
    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Movie.class), mediaType = "application/json")})
    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovieList(){
        return ResponseEntity.ok(movieService.getAll());
    }

    @Operation(
            summary = "Retrieve movie with given id",
            description = "Get only one movie, with given id"
    )
    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Movie.class), mediaType = "application/json")})
    @GetMapping("/movies/{id}")
    @ApiResponse(responseCode = "404",description = "Movie not found", content = { @Content(schema = @Schema())})
    @Parameter(name = "id", description = "ID number of movie")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) throws MovieNotFoundException {
            return ResponseEntity.ok(movieService.findById(id));
        }
    @Operation(
            summary = "Update contents of Movie object",
            description = "Change parameters of selected movie object"
    )
    @PatchMapping("/movies{id}")
    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Movie.class), mediaType = "application/json")})
    @Parameter(name = "id", description = "ID number of movie")
    public ResponseEntity<Movie> updateMovie(@RequestParam int id, @RequestBody Movie movie){
        Movie movie_update = movieService.updateMovie(movie, id);
        return ResponseEntity.ok(movie_update);
    }
    @Operation(
            summary = "Add new movie to database",
            description = "Create and add new movie object to database"
    )
    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Movie.class), mediaType = "application/json")})
    @PostMapping("/movies")
    public ResponseEntity<Movie> addNewMovie(@RequestBody Movie movie){
        movieService.addNewMovie(movie);
        return ResponseEntity.ok(movie);
    }
    @Operation(
            summary = "Delete movie from database"
    )
    @Parameter(name = "id", description = "ID number of movie")
    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int id){
        movieService.deleteMovieById(id);
        return ResponseEntity.ok().build();
    }
    @Operation(
            summary = "Update availability status of Movie",
            description = "Update available parameter of Movie object and set it TRUE"
    )
    @Parameter(name = "id", description ="ID number of movie")
    @PatchMapping("/movies/{id}/available")
    public ResponseEntity<Movie> updateAvailable(@PathVariable int id) throws MovieNotFoundException {
        Movie movie = movieService.updateIsAvailable(id);
        return ResponseEntity.ok(movie);
    }

}
