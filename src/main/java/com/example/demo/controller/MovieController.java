package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Movie;
import com.example.demo.service.MovieService;

@Controller
public class MovieController {
	@Autowired
MovieService ms;
	@GetMapping("/{name}")

public String love(@PathVariable String name, Model model) {

        model.addAttribute("name", name);  // ✅ passing data

        return "love";

	}
	@GetMapping("/movies")
	List<Movie> getAllMovies(){
		List<Movie> l=ms.movieList();
		return l;
		
	}
	@PostMapping("/movies")
	String addMoviee(@RequestBody Movie movie) {
		String s=ms.addMovie(movie);
		return s;
		
	}
	@PutMapping("/movies")
	String update(@RequestBody Movie movie) {
		String s=ms.updateMovie(movie);
		return s;
		
	}
	@GetMapping("/movies/{genere}")
	List<Movie> getByGenere(@PathVariable("genere") String genere ){
		List<Movie> l=ms.findBygenere(genere);
		return l;
		
	}
	
	@DeleteMapping("/movies/{id}")
	String deletebyId(@PathVariable("id") int id) {
		String s=ms.deleteById(id);
		return s;
	
	
}
}
