/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
/**
 *
 * @author David
 */
public class LocationManager {
    String city;
    private final String USER_AGENT = "Mozilla/5.0";
    LocationManager() throws UnsupportedEncodingException, NoSuchAlgorithmException, Exception{
       city = "";
    }
    public String findLocation(int zip) throws UnsupportedEncodingException, NoSuchAlgorithmException, Exception {
        String url = "http://ziptasticapi.com/" + zip;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
      
        BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();    
        
        while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());
        JSONObject jsonObj = new JSONObject(response.toString());
        System.out.println(jsonObj.get("city")); 
        return (String) jsonObj.get("city");
    }
    public void movieTheatre(int zip) throws UnsupportedEncodingException, NoSuchAlgorithmException, Exception {
        String url = "http://www.fandango.com/rss/moviesnearme_"+ zip + ".rss";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("Theaters from zip: " + zip);
        BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();    
        //System.out.println("exception123");
        while ((inputLine = in.readLine()) != null) {
		response.append(inputLine);
              //  System.out.println(inputLine);
        }
        in.close();
        ArrayList theaters = new ArrayList();
        ArrayList addresses = new ArrayList();
        int occurence = 0;
        int lastOccurence = 0;
        int occurence2 = 0;
        //theaters
        while ((occurence = response.indexOf("<title>", lastOccurence)) != -1) {
            //occurence = response.indexOf("<title>", lastOccurence);
            occurence2 = response.indexOf("</title>", occurence);
            theaters.add(response.substring(occurence+16, occurence2-3));
            
            lastOccurence = occurence2;
            occurence = occurence2;
        }
        //theater addresses
        occurence = 0; lastOccurence = 0; occurence2 = 0;
        while ((occurence = response.indexOf("<![CDATA[<p>", lastOccurence)) != -1) {
            //occurence = response.indexOf("<title>", lastOccurence);
            occurence2 = response.indexOf("</p>", occurence);
            addresses.add(response.substring(occurence+12, occurence2));
            
            lastOccurence = occurence2;
            occurence = occurence2;
        }
        
        //movies per theater
        ArrayList moviesPlaying[] = new ArrayList[theaters.size()];
        for (int i = 0; i < theaters.size(); i++) {
            moviesPlaying[i] = new ArrayList();
        }
        occurence = 0; lastOccurence = 0; occurence2 = 0;
        occurence = response.indexOf("<description>", lastOccurence);
        lastOccurence = occurence; occurence2 = occurence;
        int theaterCount = 0;
        while ((occurence = response.indexOf("<description><", lastOccurence)) != -1) {
            occurence2 = response.indexOf("</description>", occurence);
            String movieSection = response.substring(occurence, occurence2);
            int movieOccurence = 0; int movieOccurence2 = 0;  int lastOccurence2 = 0;
            
            while ((movieOccurence = movieSection.indexOf("\">", lastOccurence2)) != -1) {
                movieOccurence2 = movieSection.indexOf("</a>", movieOccurence);
                moviesPlaying[theaterCount].add(movieSection.substring(movieOccurence, movieOccurence2));
                lastOccurence2 = movieOccurence2;
                movieOccurence = movieOccurence2;
            }
            theaterCount += 1;
            lastOccurence = occurence2;
            occurence = occurence2;
        }
        
        //print info
        for (int i = 2; i < theaters.size(); i++) {
            System.out.println(theaters.get(i));
            System.out.println(addresses.get(i-2));
            for (int a = 0; a < moviesPlaying[i-2].size(); a++) {
                System.out.println(moviesPlaying[i-2].get(a));
            }
        } 
    
    }
}
