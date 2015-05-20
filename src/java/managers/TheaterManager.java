/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import dao.TheaterDAO;
import domains.Theater;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sam W.
 */
public class TheaterManager {
    
    private HashMap<String,Theater> theaters;
    private TheaterDAO theaterDAO;
    
    public TheaterManager(){
        theaters = new HashMap();
    }

    public TheaterDAO getTheaterDAO() {
        return theaterDAO;
    }

    public void setTheaterDAO(TheaterDAO theaterDAO) {
        this.theaterDAO = theaterDAO;
    }

    public HashMap<String, Theater> getTheaters() {
        return theaters;
    }

    public void setTheaters(HashMap<String, Theater> theaters) {
        this.theaters = theaters;
    }
    
    public void updateTheaters(){
        List<Theater> theaterList = theaterDAO.update();
        for(Theater t : theaterList){
            theaters.put(t.getName(),t);
        }
        
    }
    public List<Theater> findNearbyTheaters(int zipcode){
        List<Theater> theatersInRange = new ArrayList();
        
        for (Theater t: theaters.values()) {
            
            try {
                double[] base = findLatLong(zipcode+"");
                double distance = 0;
                
                distance = distance(base[0], base[1], t.getLatitude(), t.getLongitude(), 'm');

                System.out.println("Distance from " + zipcode + " to " + t.getName() + " is " + distance + " miles.");
                if (distance <= 5) {
                    theatersInRange.add(t);
                }
            } catch (Exception ex) {
                Logger.getLogger(TheaterManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    
    
        
        return theatersInRange;
    }
    public double[] findLatLong(String zip) throws Exception {
            String url = "http://www.zip-info.com/cgi-local/zipsrch.exe?ll=ll&zip=" + zip + "&Go=Go";
            System.out.println("ZIPCODE:" + url);
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            StringBuffer response;
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            }
            int occurence = 0;
            String searchFor = "</font></td><td align=center>";
            double latitude = 0;
            double longitude = 0;
                occurence = response.lastIndexOf(searchFor);
                //System.out.println(response);
                longitude = Double.parseDouble(response.substring(occurence+searchFor.length(), occurence+searchFor.length()+5));
                
                latitude = Double.parseDouble(response.substring(occurence-7, occurence-2));
           
               
            System.out.println("latitude: " + latitude + ", longitude: " + longitude);
            double[] array = new double[2];
            array[0] = latitude;
            array[1] = longitude;
            return array;
    }
    private double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
      double theta = lon1 - lon2;
      double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
      dist = Math.acos(dist);
      dist = rad2deg(dist);
      dist = dist * 60 * 1.1515;
      if (unit == 'K') {
        dist = dist * 1.609344;
      } else if (unit == 'N') {
        dist = dist * 0.8684;
        }
      return (dist);
    }

    private double deg2rad(double deg) {
      return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
      return (rad * 180.0 / Math.PI);
    }
}
