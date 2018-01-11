package com.turvo.service;

import com.turvo.model.AssetTracker;
import com.turvo.model.TrackingHistory;
import org.joda.time.DateTime;

import java.util.List;

public interface AssetTrackingService {

	void saveAssetTracker(AssetTracker assetTracker);

	List<AssetTracker> getLocations();

	List<TrackingHistory> getConsolidatedPings(DateTime fromTime, DateTime toTime);
}
