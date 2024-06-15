package com.example.MovieService;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Objects;
@Schema(description = "Movie class")
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID number of Movie", example = "1")
    private int ID;
    @Schema(description = "Title of movie", example = "Star wars")
    private String name;
    @Schema(description = "Category of movies, selected from [AKCJA, KOMDEIA, DRAMAT, BAJKA]", example = "AKCJA")
    @Enumerated(EnumType.STRING)
    private Category category;
    @Schema(description = "Decides if movie is available to rent", example = "true")
    private boolean is_available;

    public Movie(){}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isIs_available() {
        return is_available;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }
}
