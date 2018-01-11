package com.turvo.service;

import com.turvo.model.AssetTracker;
import com.turvo.model.TrackingHistory;
import com.turvo.persistence.LocationTrackerRepository;
import com.turvo.util.TrackerType;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service("assetTrackingService")
public class AssetTrackingServiceImpl implements AssetTrackingService {

	@Autowired
	LocationTrackerRepository locationTrackerRepository;

	private String DEFAULT_MOBILE_NUMBER = "919866666669";
	private String DEFAULT_LOCATION = "Hyderabad";
	private DateTime DEFAULT_TIME = DateTime.now();

	public AssetTrackingServiceImpl(){}

	AssetTrackingServiceImpl(LocationTrackerRepository locationTrackerRepository) {
		super();
		this.setLocationTrackerRepository(locationTrackerRepository);

	}
	@Override
	public void saveAssetTracker(AssetTracker assetTracker) {
		//set asset tracker properties
		//save vehicle asset tracker
		locationTrackerRepository.saveAssetTracker(getAssetTracker(assetTracker, TrackerType.VEHICLE));
		locationTrackerRepository.saveHistory(constructTrackingHistory(assetTracker));

		//save mobile asset tracker
		assetTracker = new AssetTracker();
		locationTrackerRepository.saveAssetTracker(getAssetTracker(assetTracker, TrackerType.MOBILE));
		locationTrackerRepository.saveHistory(constructTrackingHistory(assetTracker));
	}

	private TrackingHistory constructTrackingHistory(AssetTracker assetTracker) {
		TrackingHistory trackingHistory = new TrackingHistory();
		trackingHistory.setId(UUID.randomUUID().toString());
		trackingHistory.setDateTime(assetTracker.getDateTime());
		trackingHistory.setDeviceId(assetTracker.getDeviceId());
		trackingHistory.setTrackerType(assetTracker.getTrackerType());
		trackingHistory.setDriverId(assetTracker.getDriverId());
		return trackingHistory;
	}

	@Override
	public List<AssetTracker> getLocations() {
		return locationTrackerRepository.getLocations();
	}

	public LocationTrackerRepository getLocationTrackerRepository() {
		return locationTrackerRepository;
	}

	public void setLocationTrackerRepository(LocationTrackerRepository locationTrackerRepository) {
		this.locationTrackerRepository = locationTrackerRepository;
	}

	@Override
	public List<TrackingHistory> getConsolidatedPings(DateTime fromTime, DateTime toTime) {
		return locationTrackerRepository.getConsolidatedPings(fromTime, toTime);
	}

	private AssetTracker getAssetTracker(AssetTracker assetTracker, TrackerType trackerType) {
		assetTracker.setTrackerType(trackerType.name());
		assetTracker.setLocation(DEFAULT_LOCATION);
		assetTracker.setDateTime(DEFAULT_TIME);

		if(trackerType.name().equalsIgnoreCase("vehicle")) {
			assetTracker.setId(UUID.randomUUID().toString());
			assetTracker.setVehicleSpeed(90);
			assetTracker.setLatitude(456.78);
			assetTracker.setLongitude(984.34);
		}
		if(trackerType.name().equalsIgnoreCase("mobile")) {
			assetTracker.setId(UUID.randomUUID().toString());
			assetTracker.setMobileNumber(DEFAULT_MOBILE_NUMBER);
			assetTracker.setDeviceId(UUID.randomUUID().toString());
			assetTracker.setDriverId(UUID.randomUUID().toString());
			assetTracker.setVehicleNum(UUID.randomUUID().toString());
		}
		return assetTracker;
	}
}
