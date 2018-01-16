package com.turvo.service;

import com.turvo.model.AssetLocationTracker;
import com.turvo.model.LocationInfo;
import com.turvo.model.TrackingHistory;
import org.joda.time.DateTime;

import java.util.List;

public interface AssetTrackingService {

	void saveAssetTracker(AssetLocationTracker assetLocationTracker);

	List<LocationInfo> getLocations();

	List<TrackingHistory> getConsolidatedPings(DateTime fromTime, DateTime toTime);
}
