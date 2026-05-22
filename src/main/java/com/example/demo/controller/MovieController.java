package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    // ✅ Show all movies
    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Movie> listMovies = movieRepository.findAll();
        model.addAttribute("listMovies", listMovies);
        return "index";
    }

    // ✅ Show form to add new movie
    @GetMapping("/showNewMovieForm")
    public String showNewMovieForm(Model model) {
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        return "new_movie";
    }

    // ✅ Save movie
    @PostMapping("/saveMovie")
    public String saveMovie(@Valid @ModelAttribute("movie") Movie movie) {
        movieRepository.save(movie);
        return "redirect:/";
    }

    // ✅ Show form to update movie
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Integer id, Model model) {

        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid movie Id: " + id));

        model.addAttribute("movie", movie);
