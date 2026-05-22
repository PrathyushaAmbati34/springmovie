package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
List<Movie> findByMovieGenre(String s);
}
