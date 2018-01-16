package com.turvo.service;

import com.turvo.model.AssetLocationTracker;
import com.turvo.model.LocationInfo;
import com.turvo.model.TrackingHistory;
import com.turvo.persistence.LocationTrackerRepository;
import com.turvo.util.TrackerType;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
	public void saveAssetTracker(AssetLocationTracker assetLocationTracker) {
		//set asset tracker properties
		//save vehicle asset tracker
		locationTrackerRepository.saveAssetTracker(getAssetTracker(assetLocationTracker, TrackerType.VEHICLE));
		locationTrackerRepository.saveHistory(constructTrackingHistory(assetLocationTracker));

		//save mobile asset tracker
		assetLocationTracker = new AssetLocationTracker();
		locationTrackerRepository.saveAssetTracker(getAssetTracker(assetLocationTracker, TrackerType.MOBILE));
		locationTrackerRepository.saveHistory(constructTrackingHistory(assetLocationTracker));
	}

	private TrackingHistory constructTrackingHistory(AssetLocationTracker assetLocationTracker) {
		TrackingHistory trackingHistory = new TrackingHistory();
		trackingHistory.setId(UUID.randomUUID().toString());
		trackingHistory.setDateTime(assetLocationTracker.getDateTime());
		trackingHistory.setDeviceId(assetLocationTracker.getDeviceId());
		trackingHistory.setTrackerType(assetLocationTracker.getTrackerType());
		trackingHistory.setDriverId(assetLocationTracker.getDriverId());
		trackingHistory.setLocation(assetLocationTracker.getLocation());

		return trackingHistory;
	}

	@Override
	public List<LocationInfo> getLocations() {
		List<LocationInfo> locations = new ArrayList<>();

		locationTrackerRepository.getLocations().stream()
				.forEach(assetLocationTracker -> {
					LocationInfo locationInfo = new LocationInfo(assetLocationTracker.getLocation(),assetLocationTracker.getLatitude(),
												assetLocationTracker.getLongitude(),assetLocationTracker.getDriverId(),
												assetLocationTracker.getVehicleNum(),assetLocationTracker.getTrackerType());

					locations.add(locationInfo);
				});
		return locations;
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

	private AssetLocationTracker getAssetTracker(AssetLocationTracker assetLocationTracker, TrackerType trackerType) {
		assetLocationTracker.setTrackerType(trackerType.name());
		assetLocationTracker.setLocation(DEFAULT_LOCATION);
		assetLocationTracker.setDateTime(DEFAULT_TIME);
		assetLocationTracker.setAssetId(UUID.randomUUID().toString());

		if(trackerType.name().equalsIgnoreCase("vehicle")) {
			assetLocationTracker.setId(UUID.randomUUID().toString());
			assetLocationTracker.setVehicleSpeed(90);
			assetLocationTracker.setLatitude(456.78);
			assetLocationTracker.setLongitude(984.34);
		}
		if(trackerType.name().equalsIgnoreCase("mobile")) {
			assetLocationTracker.setId(UUID.randomUUID().toString());
			assetLocationTracker.setMobileNumber(DEFAULT_MOBILE_NUMBER);
			assetLocationTracker.setDeviceId(UUID.randomUUID().toString());
			assetLocationTracker.setDriverId(UUID.randomUUID().toString());
			assetLocationTracker.setVehicleNum(UUID.randomUUID().toString());
		}
		return assetLocationTracker;
	}
}
