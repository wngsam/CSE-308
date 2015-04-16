/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domains.Offer;
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
 * @author Desktop
 */
public class OfferDAO {
    
    private JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        
    }
    
    public void dummy(){
        
    }
    
    public List<Offer> getOffers(){
        List<Offer> offers = this.jdbcTemplate.query(
                "SELECT * FROM offers;",
                new RowMapper<Offer>(){
                    @Override
                    public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Offer offer = new Offer();
                        offer.setOfferId(rs.getInt("OfferId"));
                        offer.setName(rs.getString("Name"));
                        offer.setContent(rs.getString("Content"));
                        GregorianCalendar cal = new GregorianCalendar();
                        cal.setTime(rs.getDate("Expiration"));
                        offer.setExpiration(cal);
                        offer.setImageLink(rs.getString("ImageLink"));
                        return offer;
                    }
                }
        
        );
        
        return offers;
    }
    
    public Offer mapOffer(ResultSet rs) throws SQLException{
        Offer offer = new Offer();
        offer.setOfferId(rs.getInt("OfferId"));
        offer.setName(rs.getString("Name"));
        offer.setContent(rs.getString("Content"));
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(rs.getDate("Expiration"));
        offer.setExpiration(cal);
        offer.setImageLink(rs.getString("ImageLink"));
        return offer;
    }
    
}
