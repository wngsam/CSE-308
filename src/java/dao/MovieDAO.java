/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domains.Movie;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Sam W.
 */
public class MovieDAO {
    
    private JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        //testQuery();
    }
    
    public List<Movie> update(){
        List<Movie> offers = this.jdbcTemplate.query(
                "SELECT * FROM movies;",
                new RowMapper<Movie>(){
                    @Override
                    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Movie movie = new Movie();
                        movie.setMovieId(rs.getInt("MovieId"));
                        movie.setTitle(rs.getString("Title"));
                        GregorianCalendar cal = new GregorianCalendar();
                        cal.setTime(rs.getDate("ReleaseDate"));
                        movie.setReleaseDate(cal);
                        movie.setRating(rs.getString("Rating"));
                        movie.setSynopsis(rs.getString("Synopsis"));
                        movie.setPoster(rs.getString("Poster"));
                        movie.setWeekendGross(rs.getBigDecimal("WeekendGross").doubleValue());
                        movie.setNumOfTheaters(rs.getInt("NumOfTheaters"));
                        movie.setTheaterAverage(rs.getBigDecimal("TheaterAverage").doubleValue());
                        movie.setStudio(rs.getString("Studio"));
                        movie.setTrailer(rs.getString("Trailer"));
                        return movie;
                    }
                }
        
        );
        
        return offers;
    }
    
}
