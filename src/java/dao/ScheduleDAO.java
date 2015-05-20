/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domains.Schedule;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Desktop
 */
public class ScheduleDAO {
    
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public List<Schedule> update(){
        List<Schedule> schedules = this.jdbcTemplate.query(
                "SELECT * FROM showtimes;",
                new RowMapper<Schedule>(){
                    @Override
                    public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Schedule sch = new Schedule();
                        sch.setId(rs.getInt("ShowTimeId"));
                        sch.setMovieId(rs.getInt("MovieId"));
                        sch.setTheaterId(rs.getInt("TheaterId"));
                        GregorianCalendar cal = new GregorianCalendar();
                        cal.setTime(rs.getTimestamp("ShowTime"));
                        //System.out.println(cal.get(Calendar.HOUR)+" "+cal.get(Calendar.AM_PM));
                        sch.setShowTime(cal);
                        sch.setCapacity(rs.getInt("Capacity"));
                        return sch;
                    }
                }
        );
        return schedules;
    }
    
}
