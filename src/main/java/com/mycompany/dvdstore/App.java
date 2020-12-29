package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieController;
import com.mycompany.dvdstore.repository.FileMovieRepository;
import com.mycompany.dvdstore.service.DefaultMovieService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        FileMovieRepository movieRepository = new FileMovieRepository();
        DefaultMovieService defaultMovieService = new DefaultMovieService();
        defaultMovieService.setMovieRepository(movieRepository);

        MovieController movieController = new MovieController();
        movieController.setMovieService(defaultMovieService);
        movieController.addUsingConsole();


    }
}
