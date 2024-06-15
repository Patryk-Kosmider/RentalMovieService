package com.example.MovieService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;


@RestControllerAdvice
public class MovieAdvice {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(MovieNotFoundException mft){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
    }

    @ExceptionHandler(MovieNoIdGivenException.class)
    public ResponseEntity<String> handleNoIdGivenException(MovieNoIdGivenException mid){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't add movie wihout ID");
    }

}
