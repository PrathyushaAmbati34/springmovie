package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Movie {

    @Id
    private Integer id;

    @NotEmpty(message = "Movie name cannot be empty")
    private String movieName;

    @NotEmpty(message = "Genre cannot be empty")
    private String movieGenre;

    public Movie() {
    }

    public Movie(Integer id, String movieName, String movieGenre) {
        this.id = id;
        this.movieName = movieName;
        this.movieGenre = movieGenre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }
}
