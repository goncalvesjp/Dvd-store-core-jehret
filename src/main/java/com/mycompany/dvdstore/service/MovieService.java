package com.mycompany.dvdstore.service;


import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.GoLiveMovieRepository;
import com.mycompany.dvdstore.repository.MovieRepository;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;

public class MovieService implements MovieServiceInterface{

    MovieRepositoryInterface goLiveMovieRepository ;//= new GoLiveMovieRepository();

    public void registerMovie(Movie movie){
        goLiveMovieRepository.add(movie);
        //System.out.println(movie.getTitle() + " was added.");
    }
}
