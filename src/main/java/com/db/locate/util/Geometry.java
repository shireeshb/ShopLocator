package com.db.locate.util;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.db.locate.dto.LocationDetail;

public class Geometry {
	 private LocationDetail location ;
	 private String location_type;
	 
	 @JsonIgnore
	 private Object bounds;
	 
	 @JsonIgnore
	 private Object viewport;

	/**
	 * @return the location
	 */
	public LocationDetail getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(LocationDetail location) {
		this.location = location;
	}

	/**
	 * @return the location_type
	 */
	public String getLocation_type() {
		return location_type;
	}

	/**
	 * @param location_type the location_type to set
	 */
	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}

	/**
	 * @return the bounds
	 */
	public Object getBounds() {
		return bounds;
	}

	/**
	 * @param bounds the bounds to set
	 */
	public void setBounds(Object bounds) {
		this.bounds = bounds;
	}

	/**
	 * @return the viewport
	 */
	public Object getViewport() {
		return viewport;
	}

	/**
	 * @param viewport the viewport to set
	 */
	public void setViewport(Object viewport) {
		this.viewport = viewport;
	}
	 
	 
}
