package com.turvo.model;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection="assettracker")
public class AssetTracker implements Serializable {

	@Id
	private String id;
	private Double latitude;
	private Double longitude;
	private String location;
	private DateTime dateTime;
	private Integer vehicleSpeed;
	private String trackerType;
	private String mobileNumber;
	private String deviceId;
	private String driverId;
	private String vehicleNum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public DateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getVehicleSpeed() {
		return vehicleSpeed;
	}

	public void setVehicleSpeed(Integer vehicleSpeed) {
		this.vehicleSpeed = vehicleSpeed;
	}

	public String getTrackerType() {
		return trackerType;
	}

	public void setTrackerType(String trackerType) {
		this.trackerType = trackerType;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
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

	@Override
	public String toString() {
		return "AssetTracker{" +
					   "id='" + id + '\'' +
					   ", latitude=" + latitude +
					   ", longitude=" + longitude +
					   ", location='" + location + '\'' +
					   ", dateTime=" + dateTime +
					   ", vehicleSpeed=" + vehicleSpeed +
					   ", trackerType='" + trackerType + '\'' +
					   ", mobileNumber='" + mobileNumber + '\'' +
					   ", deviceId='" + deviceId + '\'' +
					   ", driverId='" + driverId + '\'' +
					   ", vehicleNum='" + vehicleNum + '\'' +
					   '}';
	}
}
