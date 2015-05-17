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
    static int count = 0;
    
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public boolean star(Movie movie){
        boolean confirmation = false;
        this.jdbcTemplate.update(
        "UPDATE movies \n" +
        "SET Stars = ?, Rates = ? \n" +
        "WHERE MovieId = ?;",movie.getStars(),movie.getRates(),movie.getId());
        confirmation = true;
        return confirmation;
    }
    
    public boolean adminEditMovie(Movie movie){
        boolean confirmation = false;
        String releasedate = "20121212";
        String trailer = "abc";
        this.jdbcTemplate.update(
        "UPDATE movies \n" +
        "SET MovieId = ?, Title = ?, ReleaseDate = ?, Rating = ?, Synopsis = ?, Poster = ?, WeekendGross = ?, NumOfTheaters = ?, TheaterAverage = ?, Trailer = ?, Stars = ? \n" +
        "WHERE MovieId = ?;",
        movie.getId(),movie.getTitle(),releasedate,movie.getRating(),movie.getSynopsis(),
        movie.getPoster(),movie.getWeekendGross(),movie.getNumOfTheaters(),movie.getTheaterAverage(),
        trailer,movie.getStars(),movie.getId());
        confirmation = true;
        return confirmation;
    }
    
    public boolean adminAddMovie(Movie movie){
        boolean confirmation = false;
        movie.setId(++count);
        movie.setStars(0);
        String releaseDate = "20201212";
        
        this.jdbcTemplate.update(
        "INSERT INTO movies values (?,?,?,?,?,?,?,?,?,?,?,?)",
        movie.getId(),movie.getTitle(),releaseDate,movie.getRating(),movie.getSynopsis(),movie.getPoster(),movie.getWeekendGross(),
        movie.getNumOfTheaters(),movie.getTheaterAverage(),movie.getTrailer(),0,0);
        confirmation = true;
        return confirmation;
    }
    
    public boolean adminDelMovie(int id){
        boolean confirmation = false;
        
        this.jdbcTemplate.update(
        "UPDATE comments \n" +
        "SET MovieId = 0 \n" +
        "WHERE MovieId = "+id+";");
        this.jdbcTemplate.update(
        "UPDATE favoritemovies \n" +
        "SET MovieId = 0 \n" +
        "WHERE MovieId = "+id+";");
        this.jdbcTemplate.update("DELETE from moviecasts where MovieId = "+id+";");
        this.jdbcTemplate.update("DELETE from moviegenres where MovieId = "+id+";");
        this.jdbcTemplate.update("DELETE from movieimages where MovieId = "+id+";");
        this.jdbcTemplate.update(
        "UPDATE showtimes \n" +
        "SET MovieId = 0 \n" +
        "WHERE MovieId = "+id+";");
        this.jdbcTemplate.update("DELETE from movies where MovieId = "+id+";");
        
        confirmation = true;
        return confirmation;
    }
    
    //can be used by user or admin
    public boolean deleteComment(Review comment){
        boolean confirmation = false;
        this.jdbcTemplate.update("DELETE from comments where UserId = "+comment.getUserId()+" and title = '"+comment.getTitle()+"';");
        confirmation = true;
        return confirmation;
    }
    
    //writing comments, need fix date
    public boolean writeComment(Review comment){
        boolean confirmation = false;
        String date = "14920101";
        this.jdbcTemplate.update(
        "INSERT INTO comments values (?,?,?,?,?,?)",
        comment.getTitle(),comment.getUserId(),comment.getContent(),comment.getMovieId(),date,comment.getStars());
        confirmation = true;
        return confirmation;
    }
    
    public List<Movie> update(){
        List<Movie> movies = this.jdbcTemplate.query(
                "SELECT * FROM movies WHERE MovieId != 0;",
                new RowMapper<Movie>(){
                    @Override
                    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Movie movie = new Movie();
                        int movieId = rs.getInt("MovieId");
                        if(movieId>count){count=movieId;}
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
                        //movie.setStudio(rs.getString("Studio"));
                        movie.setTrailer(rs.getString("Trailer"));
                        movie.setGenre(getGenres(movieId));
                        movie.setCast(getCasts(movieId));
                        movie.setImages(getImages(movieId));
                        movie.setReviews(getReviews(movieId));
                        movie.setStars(rs.getBigDecimal("Stars").doubleValue());
                        movie.setRates(rs.getInt("Rates"));
                        movie.calculateStarRating();
                        return movie;
                    }
                }
        );
        return movies;
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
    
    public List<Actor> getCasts(int movieId){
        String query = "SELECT * FROM moviecasts"
              + " WHERE MovieId="+movieId+";";
        List<String> actorIds = this.jdbcTemplate.query(
                query,
                new RowMapper<String>(){
                    @Override
                    public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return Integer.toString(rs.getInt("ActorId"));
                    }
                }
        );
        
        List<Actor> actors = new ArrayList();
        for(String i : actorIds){
            actors.add(getActor(Integer.parseInt(i)));
        }
        return actors;
    }
    
    public Actor getActor(int actorId){
        Actor actor = this.jdbcTemplate.queryForObject(
                "SELECT * FROM actors" +
                " WHERE ActorId="+actorId+";", new RowMapper<Actor>(){
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
                        actor.setPicture(rs.getString("Picture"));
                        return actor;
                    }
                }
        );
        return actor;
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
        String query = "SELECT * FROM comments"
              + " WHERE MovieId="+movieId+";";
        List<Review> reviews = this.jdbcTemplate.query(
                query,
                new RowMapper<Review>(){
                    @Override
                    public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Review review = new Review();
                        review.setTitle(rs.getString("Title"));
                        review.setUserId(rs.getInt("UserId"));
                        
                        review.setName(findUsernameFromId(review.getUserId()));
                        
                        review.setContent(rs.getString("Content"));
                        review.setMovieId(rs.getInt("MovieId"));
                        GregorianCalendar cal = new GregorianCalendar();
                        cal.setTime(rs.getDate("Date"));
                        review.setDate(cal);
                        review.setStars(rs.getInt("Stars"));
                        return review;
                    }
                }
        );
        return reviews;
    }
    
    public String findUsernameFromId(int userId){
        return this.jdbcTemplate.queryForObject(
                        "SELECT FirstName, LastName FROM users" +
                        " WHERE UserId= "+userId+";", new RowMapper<String>(){
                        @Override
                        public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return rs.getString("FirstName");
                                //+" "+rs.getString("LastName");
                        }
                        }
                        );
    }
    
}
