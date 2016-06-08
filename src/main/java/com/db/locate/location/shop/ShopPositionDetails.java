package com.db.locate.location.shop;

import org.springframework.stereotype.Component;

import com.db.locate.location.address.ShopAddress;

@Component
public class ShopPositionDetails {
	private String shopName;
	private ShopAddress shopAddress;
	private String shopLongitude;
	private String shopLatitude;
	/**
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}
	/**
	 * @param shopName the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	/**
	 * @return the shopAddress
	 */
	public ShopAddress getShopAddress() {
		return shopAddress;
	}
	/**
	 * @param shopAddress the shopAddress to set
	 */
	public void setShopAddress(ShopAddress shopAddress) {
		this.shopAddress = shopAddress;
	}
	/**
	 * @return the shopLongitude
	 */
	public String getShopLongitude() {
		return shopLongitude;
	}
	/**
	 * @param shopLongitude the shopLongitude to set
	 */
	public void setShopLongitude(String shopLongitude) {
		this.shopLongitude = shopLongitude;
	}
	/**
	 * @return the shopLatitude
	 */
	public String getShopLatitude() {
		return shopLatitude;
	}
	/**
	 * @param shopLatitude the shopLatitude to set
	 */
	public void setShopLatitude(String shopLatitude) {
		this.shopLatitude = shopLatitude;
	}
	
	
}
