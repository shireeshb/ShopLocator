package com.db.locate.location.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.locate.location.address.ShopDetails;
import com.db.locate.location.service.LocationService;


@RestController
@RequestMapping("/locate")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	/**
	 * This method will return the longitude and latitude
	 * @param address
	 * @return
	 * @throws IOException 
	 */
		
	@RequestMapping(value="/location", method=RequestMethod.POST)
	public String locatePosition(@RequestBody ShopDetails shopDetails) throws IOException{
		
		String details = locationService.convertToLatLong(shopDetails);		
		return details;
	}

	/**
	 * This method will return the shop address
	 * @param lat
	 * @param lng
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/shop")
	public String locateNearestShop(@RequestParam(value = "customerLatitude") String lat, @RequestParam(value = "customerLongitude") String lng) throws IOException {

		String latlng = String.format("%s,%s", lat,lng );
		String shopAddress = locationService.convertFromLatLong(latlng);
		
		return shopAddress;
		

	}
	
	
}
