package com.mycompany.dvdstore;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieService;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        System.out.println( "Saisisez le titre" );
        String title = sc.next();
        System.out.println( "Saisisez le genre du film" );
        String genre = sc.next();

        MovieService movieService = new MovieService();
        Movie movie = new Movie(title, genre);
        movieService.registerMovie(movie);


    }
}
