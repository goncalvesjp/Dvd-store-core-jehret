package com.mycompany.dvdstore.service;


import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;

public class DefaultMovieService implements MovieServiceInterface{

    MovieRepositoryInterface movieRepository;

    public void setMovieRepository(MovieRepositoryInterface movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void registerMovie(Movie movie){
        movieRepository.add(movie);
        //System.out.println(movie.getTitle() + " was added.");
    }
}
