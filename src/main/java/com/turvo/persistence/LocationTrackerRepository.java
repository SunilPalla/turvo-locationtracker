package com.turvo.persistence;

import com.turvo.model.AssetLocationTracker;
import com.turvo.model.TrackingHistory;
import org.joda.time.DateTime;

import java.util.List;

public interface LocationTrackerRepository {

	void saveAssetTracker(AssetLocationTracker assetLocationTracker);

	List<AssetLocationTracker> getLocations();

	void saveHistory(TrackingHistory trackingHistory);

	List<TrackingHistory> getConsolidatedPings(DateTime fromTime, DateTime toTime);
}
