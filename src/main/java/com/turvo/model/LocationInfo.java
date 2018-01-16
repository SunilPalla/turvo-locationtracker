package com.turvo.model;


public class LocationInfo {

	private String locationName;
	private Double latitude;
	private Double longitude;
	private String driverId;
	private String vehicleNum;
	private String trackerType;

	public LocationInfo(String locationName, Double latitude, Double longitude, String driverId, String vehicleNum,String trackerType) {
		this.locationName = locationName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.driverId = driverId;
		this.vehicleNum = vehicleNum;
		this.trackerType = trackerType;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	public String getTrackerType() {
		return trackerType;
	}

	public void setTrackerType(String trackerType) {
		this.trackerType = trackerType;
	}
}
