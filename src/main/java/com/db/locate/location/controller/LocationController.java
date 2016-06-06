package com.db.locate.location.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.locate.location.dto.GoogleResponse;
import com.db.locate.location.dto.Result;
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
	@RequestMapping("/location")
	public String locatePosition(@RequestParam(value="address",defaultValue="Pune") String address) throws IOException{
		GoogleResponse res = locationService.convertToLatLong(address);
		
		if (res.getStatus().equals("OK")) {
			for (Result result : res.getResults())
				return String.format("Address Lattitude: %s, Longitude: %s Location: %s",
						result.getGeometry().getLocation().getLat(),
						result.getGeometry().getLocation().getLng(), address);

		} else {
			return res.getStatus();
		}
		return address;
	}
	
	/**
	 * This method will return the shop address
	 * @param lat
	 * @param lng
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/shop")
	public String locateNearestShop(@RequestParam(value = "lat") String lat, @RequestParam(value = "lng") String lng) throws IOException {

		String latlng = String.format("%s,%s", lat,lng );
		GoogleResponse res = locationService.convertFromLatLong(latlng);
		if (res.getStatus().equals("OK")) {
			for (Result result : res.getResults())
				return String.format("Lattitude: %s, Longitude: %s Address: %s",
						result.getGeometry().getLocation().getLat(),
						result.getGeometry().getLocation().getLng(), result.getFormatted_address());

		} else {
			return res.getStatus();
		}
		return latlng;
		

	}
	
	
}
