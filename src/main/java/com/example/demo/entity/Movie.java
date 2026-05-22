package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
public class Movie {
	@Id
	private int id;
	@NotEmpty
	private String movieName;
    private String movieGenere;
   

}