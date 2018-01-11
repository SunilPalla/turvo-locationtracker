package com.turvo.persistence;

import com.turvo.model.AssetTracker;
import com.turvo.model.TrackingHistory;
import com.turvo.util.TrackerType;
import org.joda.time.DateTime;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LocationTrackerRepository {

	void saveAssetTracker(AssetTracker assetTracker);

	List<AssetTracker> getLocations();

	void saveHistory(TrackingHistory trackingHistory);

	List<TrackingHistory> getConsolidatedPings(DateTime fromTime, DateTime toTime);
}
