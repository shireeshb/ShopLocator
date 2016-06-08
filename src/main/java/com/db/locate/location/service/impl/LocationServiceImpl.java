package com.db.locate.location.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.locate.location.address.GoogleResponse;
import com.db.locate.location.address.Result;
import com.db.locate.location.address.ShopDetails;
import com.db.locate.location.service.LocationService;
import com.db.locate.location.shop.ShopPositionDetails;
import com.db.locate.location.util.UrlGenerator;

@Service
public class LocationServiceImpl implements LocationService{

	 @Autowired
	 private UrlGenerator urlGenerator;
	 @Autowired 
	 private ShopPositionDetails shopPositionDetails;
	 
	 public ShopPositionDetails setShopPositondetails(ShopDetails shopDetails,GoogleResponse res) throws IOException{
		// GoogleResponse res = convertToLatLong(shopDetails);
		 shopPositionDetails.setShopName(shopDetails.getShopName());
		 shopPositionDetails.setShopAddress(shopDetails.getShopAddress());
		 if (res.getStatus().equals("OK")) {
				for (Result result : res.getResults()){
					shopPositionDetails.setShopLatitude(result.getGeometry().getLocation().getLat());
					shopPositionDetails.setShopLongitude(result.getGeometry().getLocation().getLng());
				}
				
			}
		 return shopPositionDetails;
	 }
	 /**
	  * This method gives lat & lng
	  */
	 public String convertToLatLong(ShopDetails shopDetails)  {
		 InputStream in = null;
		 GoogleResponse response = null;
		try {
			URL url = urlGenerator.createAddressUrl(shopDetails);
			URLConnection conn = url.openConnection();
			 in = conn.getInputStream() ;
			 ObjectMapper mapper = new ObjectMapper();
			 response = mapper.readValue(in,GoogleResponse.class);
			 if( response.getStatus().equals("OK")){
			
				 setShopPositondetails(shopDetails, response);
				 return "Latitude " + shopPositionDetails.getShopLatitude() + " " + "Longitude " + shopPositionDetails.getShopLongitude();
			 }			 
			 
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{		 
		 try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return response.getStatus();
		 		  
	 }
	 /**
	  * This method give address
	  */
	 
	 public String convertFromLatLong(String latlongString) {
		 URL url;
		 GoogleResponse res = null;
		 InputStream in = null;
		try {
			url = urlGenerator.createLocationURL(latlongString);
			 URLConnection conn = url.openConnection();

			 in = conn.getInputStream() ;
			 ObjectMapper mapper = new ObjectMapper();
			 res = mapper.readValue(in,GoogleResponse.class);
			 
				if (res.getStatus().equals("OK")) {
					for (Result result : res.getResults())
						return String.format("Address: %s", result.getFormatted_address());

				} 
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 return res.getStatus();
	 }
	 
}
