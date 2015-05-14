/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domains.Giftcard;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author JaeWoong
 */
public class GiftcardDAO {
     private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
     public boolean addGiftcard(Giftcard giftcard){
        boolean confirmation = false;
        
        this.jdbcTemplate.update(
        "INSERT INTO giftcards values (?,?)",
        giftcard.getGiftcardId(),giftcard.getAmount());
        confirmation = true;
        return confirmation;
    }  
}
