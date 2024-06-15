package com.example.MovieService;

public class MovieNoIdGivenException extends Exception{
    public MovieNoIdGivenException() {
        super("Can't add movie without id");
    }
}
