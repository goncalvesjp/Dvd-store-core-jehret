package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieService;

import java.util.Scanner;

public class MovieController {

    private MovieService movieService = new MovieService();

    public void addUsingConsole(){
        Scanner sc = new Scanner(System.in);
        System.out.println( "Saisisez le titre:" );
        String title=sc.nextLine();

        System.out.println( "Saisisez le genre du film:" );
        String genre = sc.nextLine();

        MovieService movieService = new MovieService();
        Movie movie = new Movie(title, genre);
        movieService.registerMovie(movie);
    }
}
