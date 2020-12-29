package com.mycompany.dvdstore.repository;

import com.mycompany.dvdstore.entity.Movie;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileMovieRepository implements MovieRepositoryInterface{

    private File file;

    public void add(Movie movie) {
        FileWriter writer;
        try {
            writer = new FileWriter(file, true);
            //writer = new FileWriter("movies.csv", true);
            writer.write(movie.getTitle()
                    + ";" + movie.getGenre() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFile(File file) {
        this.file = file;
    }
}
