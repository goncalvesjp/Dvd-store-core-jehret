package com.mycompany.dvdstore.service;


import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMovieService implements MovieServiceInterface {

    @Autowired
    private MovieRepositoryInterface movieRepository;

    public void setMovieRepository(MovieRepositoryInterface movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void registerMovie(Movie movie) {
        movieRepository.add(movie);
        //System.out.println(movie.getTitle() + " was added.");
    }

    @Override
    public List<Movie> getMovieList() {
        return movieRepository.list();
    }
}
