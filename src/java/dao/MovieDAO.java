/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domains.Actor;
import domains.Movie;
import domains.Review;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    }
    
    public List<Movie> update(){
        List<Movie> offers = this.jdbcTemplate.query(
                "SELECT * FROM movies;",
                new RowMapper<Movie>(){
                    @Override
                    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Movie movie = new Movie();
                        int movieId = rs.getInt("MovieId");
                        movie.setId(movieId);
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
                        movie.setGenre(getGenres(movieId));
                        movie.setCast(getCasts(movieId));
                        movie.setImages(getImages(movieId));
                        movie.setReviews(getReviews(movieId));
                        return movie;
                    }
                }
        
        );
        
        return offers;
    }
    
    public List<String> getGenres(int movieId){
        String query = "SELECT * FROM moviegenres"
              + " WHERE MovieId="+movieId+";";
        List<String> genres = this.jdbcTemplate.query(
                query,
                new RowMapper<String>(){
                    @Override
                    public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return rs.getString("Genre");
                    }
                }
        );
        return genres;
    }
    
    public Actor getActor(int actorId){
        String query = "SELECT * FROM actors"
              + " WHERE ActorId="+actorId+";";
        Actor actor = this.jdbcTemplate.queryForObject(
                query, new Object[]{1212L},
                new RowMapper<Actor>(){
                    @Override
                    public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Actor actor = new Actor();
                        actor.setActorId(rs.getInt("ActorId"));
                        actor.setFirstName(rs.getString("FirstName"));
                        actor.setLastName(rs.getString("LastName"));
                        GregorianCalendar cal = new GregorianCalendar();
                        cal.setTime(rs.getDate("BirthDate"));
                        actor.setBirthDate(cal);
                        actor.setImdb(rs.getString("Imdb"));
                        return actor;
                    }
                }
        );
        return actor;
    }
    
    public List<Actor> getCasts(int movieId){
        String query = "SELECT * FROM moviecasts"
              + " WHERE MovieId="+movieId+";";
        List<String> actorIds = this.jdbcTemplate.query(
                query,
                new RowMapper<String>(){
                    @Override
                    public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return String.valueOf(rs.getInt("ActorId"));
                    }
                }
        );
        
        List<Actor> actors = new ArrayList();
        for(String i : actorIds){
            actors.add(getActor(Integer.parseInt(i)));
        }
        return actors;
    }
    
    public List<String> getImages(int movieId){
        String query = "SELECT * FROM movieimages"
              + " WHERE MovieId="+movieId+";";
        List<String> images = this.jdbcTemplate.query(
                query,
                new RowMapper<String>(){
                    @Override
                    public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return "assets\\img\\"+rs.getString("ImageLink");
                    }
                }
        );
        return images;
    }
    
    public List<Review> getReviews(int movieId){
        String query = "SELECT * FROM reviews"
              + " WHERE MovieId="+movieId+";";
        List<Review> reviews = this.jdbcTemplate.query(
                query,
                new RowMapper<Review>(){
                    @Override
                    public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Review review = new Review();
                        review.setTitle(rs.getString("Title"));
                        review.setUserId(rs.getInt("UserId"));
                        review.setContent(rs.getString("Content"));
                        review.setMovieId(movieId);
                        GregorianCalendar cal = new GregorianCalendar();
                        cal.setTime(rs.getDate("Date"));
                        review.setDate(cal);
                        review.setUpvotes(rs.getInt("Upvotes"));
                        return review;
                    }
                }
        );
        return reviews;
    }
    
}
