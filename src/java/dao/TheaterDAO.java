/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domains.Theater;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Desktop
 */
public class TheaterDAO {
    
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public List<Theater> update(){
        List<Theater> theaters = this.jdbcTemplate.query(
                "SELECT * FROM theaters;",
                new RowMapper<Theater>(){
                    @Override
                    public Theater mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Theater theater = new Theater();
                        theater.setId(rs.getInt("TheaterId"));
                        theater.setName(rs.getString("Name"));
                        theater.setAddress(rs.getString("Address"));
                        theater.setPhone(rs.getInt("Phone"));
                        theater.setLongitude(rs.getBigDecimal("Longitude").doubleValue());
                        theater.setLatitude(rs.getBigDecimal("Latitude").doubleValue());
                        return theater;
                    }
                }
        );
        return theaters;
    }
    
}
