package com.mycompany.dvdstore.repository;

import com.mycompany.dvdstore.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class MovieRepository implements MovieRepositoryInterface {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie add(Movie movie) {

        KeyHolder kh = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement pstmt =
                    connection.prepareStatement("INSERT INTO MOVIE (TITLE,GENRE,DESCRIPTION) VALUES (?,?,?)",
                            Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, movie.getTitle());
            pstmt.setString(2, movie.getGenre());
            pstmt.setString(3, movie.getDescription());

            return pstmt;
        }, kh);

        movie.setId(Long.parseLong(kh.getKeys().get("id").toString()));

        return movie;
    }

    @Override
    public List<Movie> list() {
        return jdbcTemplate.query("select id, title, genre from movie",
                (rs, rowNum) -> new Movie(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("genre")));
    }

    @Override
    public Movie getById(long id) {
        return jdbcTemplate.queryForObject("select id, title, genre, description from movie where id=?",
                new Object[]{id},
                (rs, rowNum) -> new Movie(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getString("description")));
    }


}
