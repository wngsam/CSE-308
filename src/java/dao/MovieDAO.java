/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

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
    
    public void testQuery(){
        try{
            this.jdbcTemplate.update("CREATE TABLE pet"+ 
                    "(name VARCHAR(20), owner VARCHAR(20), species VARCHAR(20), sex CHAR(1), birth DATE, death DATE);");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
