package com.db.locate.location.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.locate.util.GoogleResponse;
import com.db.locate.util.Result;
import com.db.locate.util.LocationConvertor;;

@RestController
@RequestMapping("/locate")
public class LocationController {
	
	@RequestMapping("/location")
	public String locatePosition(@RequestParam(value="address",defaultValue="Pune") String address){
		GoogleResponse res = null;
		try {
			res = new LocationConvertor().convertToLatLong(address);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
}
