package com.mycompany.dvdstore.repository.memory;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {
    List<Movie> movies = new ArrayList<>();
    static long cpt=0L;


    @Override
    public <S extends Movie> S save(S movie) {
        cpt++;
        movie.setId(cpt);
        movies.add(movie);
        System.out.println("The movie " + movie.getTitle() + " has been added.");
        return movie;
    }

    @Override
    public <S extends Movie> Iterable<S> saveAll(Iterable<S> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movies.stream().
                filter(m -> m.getId()==id).
                findFirst();
        //return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Movie> findAll() {
        return movies;
    }

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Movie movie) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Movie> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();
    }
}
