package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;

@Service
public class MovieService {
	@Autowired
	MovieRepository mr;
public List<Movie> movieList(){
	List<Movie> l=mr.findAll();
	return l;
}
	public String addMovie(Movie movie) {
		Movie moviee=mr.save(movie);
				if(moviee!=null)
		return "inserted";
				else return "problem";	
		
		
	}
	public String updateMovie(Movie movie) {
		mr.save(movie);
		return "updated";
	}
	public List<Movie> findBygenere(String s) {
		List<Movie> o=mr.findByMovieGenere(s);
		return o;
		
	}
	public String deleteById(int id) {
	    mr.deleteById(id);
		return "deleted";
	}
	
	

}
