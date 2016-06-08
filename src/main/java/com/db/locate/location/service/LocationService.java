package com.db.locate.location.service;

import com.db.locate.location.address.ShopDetails;

public interface LocationService {
	public String convertToLatLong(ShopDetails fullAddress);
	public String convertFromLatLong(String latlongString);
	
}
