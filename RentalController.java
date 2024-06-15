package pl.pjatk.rental;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
@Tag(name="Rental service", description = "Rent movies")
@RestController
@RequestMapping("/rent")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @Operation(
            summary = "Retrieve Movie from database with given ID"
    )
    @Parameter(name = "id", description = "ID number of Movie")
    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Movie.class), mediaType = "application/json")})
    @ApiResponse(responseCode = "404", description = "Movie not found", content = {@Content(schema = @Schema())})
    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable int id) {
            return ResponseEntity.ok(rentalService.getMovie(id));
    }
    @Operation(
            summary = "Set Movie availability to True",
            description = "Set movie availability to True, which makes it available to rent"
    )
    @Parameter(name = "id", description = "ID number of Movie")
    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Movie.class), mediaType = "application/json")})
    @ApiResponse(responseCode = "404", description = "Movie not found", content = {@Content(schema = @Schema())})
    @PostMapping("/movie/{id}")
    public ResponseEntity<Void> returnMovie(@PathVariable int id) {
        rentalService.returnMovie(id);
        return ResponseEntity.ok().build();


    }
}
