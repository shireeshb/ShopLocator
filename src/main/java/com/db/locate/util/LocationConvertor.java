package com.db.locate.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import org.codehaus.jackson.map.ObjectMapper;


public class LocationConvertor {

	 private static final String URL = "http://maps.googleapis.com/maps/api/geocode/json";
	 
	 public GoogleResponse convertToLatLong(String fullAddress) throws IOException {
		 URL url = new URL(URL + "?address=" + URLEncoder.encode(fullAddress, "UTF-8") + "&sensor=false");
				  // Open the Connection
				  URLConnection conn = url.openConnection();

				  InputStream in = conn.getInputStream() ;
				  ObjectMapper mapper = new ObjectMapper();
				  GoogleResponse response = (GoogleResponse)mapper.readValue(in,GoogleResponse.class);
				  in.close();
				  return response;
				  
	 }
	 
	 public GoogleResponse convertFromLatLong(String latlongString) throws IOException {
		 URL url = new URL(URL + "?latlng="
				    + URLEncoder.encode(latlongString, "UTF-8") + "&sensor=false");
				  // Open the Connection
				  URLConnection conn = url.openConnection();

				  InputStream in = conn.getInputStream() ;
				  ObjectMapper mapper = new ObjectMapper();
				  GoogleResponse response = (GoogleResponse)mapper.readValue(in,GoogleResponse.class);
				  in.close();
				  return response;
	 }
}
