package com.db.locate.location.util;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Component;

import com.db.locate.location.address.ShopDetails;

@Component
public class UrlGenerator {
	private static final String URL = "http://maps.googleapis.com/maps/api/geocode/json";
	
	public URL createAddressUrl (ShopDetails shopDetails) throws UnsupportedEncodingException, MalformedURLException {
		String details = shopDetails.getShopName() + " " + shopDetails.getShopAddress().getNumber() + " " + shopDetails.getShopAddress().getPostCode();
		return new URL(URL + "?address=" + URLEncoder.encode(details, "UTF-8") + "&sensor=false");			
	}
	
	public URL createLocationURL (String latlongString) throws MalformedURLException, UnsupportedEncodingException {
		return new URL(URL + "?latlng=" + URLEncoder.encode(latlongString, "UTF-8") + "&sensor=false");
	}
	
}
