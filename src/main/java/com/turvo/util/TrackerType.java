package com.turvo.util;

public enum TrackerType {

	VEHICLE("vehicle"),
	MOBILE("mobile");

	String trackerType;

	TrackerType(String trackerType) {
		this.trackerType = trackerType;
	}

	public String getTrackerType() {
		return trackerType;
	}
}
