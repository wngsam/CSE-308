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
        System.out.println("exception123");
        while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());
        JSONObject jsonObj = new JSONObject(response.toString());
        System.out.println(jsonObj.get("city")); 
        return (String) jsonObj.get("city");
    }
}
