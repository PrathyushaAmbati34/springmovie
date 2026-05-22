package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

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

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Movie> listMovies = movieRepository.findAll();
        model.addAttribute("listMovies", listMovies);
        return "index";
    }

    @GetMapping("/showNewMovieForm")
    public String showNewMovieForm(Model model) {
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        return "new_movie";
    }

    @PostMapping("/saveMovie")
    public String saveMovie(@Valid @ModelAttribute("movie") Movie movie) {
        movieRepository.save(movie);
        return "redirect:/";
    }

    @GetMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable Integer id) {
        movieRepository.deleteById(id);
        return "redirect:/";
    }
}
