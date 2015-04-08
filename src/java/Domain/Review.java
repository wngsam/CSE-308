/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;
import java.util.*;
/**
 *
 * @author DreamRealizer
 */
public class Review {
    int id;
    String title;
    User reviewer;
    String content;
    Movie movie;
    GregorianCalendar date;
    int upvotes;
}
