package com.clouderwok.vts.bean;

public class Position {
	/**
	 * 定位经度
	 */
	private Double longitude = 0.0D;
	
	/**
	 * 定位纬度
	 */
	private Double latitude = 0.0D;
	
	/**
	 * 航向角度
	 */
	private Double courseAngle = 0.0D;
	
	/**
	 * 海拔高度
	 */
	private Double altitude = 0.0D;

	public Position() {
		super();
	}

	public Position(Double longitude, Double latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getCourseAngle() {
		return courseAngle;
	}

	public void setCourseAngle(Double courseAngle) {
		this.courseAngle = courseAngle;
	}

	public Double getAltitude() {
		return altitude;
	}

	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}
	
}
