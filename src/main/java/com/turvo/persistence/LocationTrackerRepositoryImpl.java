package com.turvo.persistence;

import com.turvo.config.MongoConfig;
import com.turvo.model.AssetLocationTracker;
import com.turvo.model.TrackingHistory;
import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

@Repository
public class LocationTrackerRepositoryImpl implements  LocationTrackerRepository {

	private MongoTemplate mongoTemplate;


	@Override
	public void saveAssetTracker(AssetLocationTracker assetLocationTracker) {
		getMongoTemplate().insert(assetLocationTracker);
	}

	@Override
	public List<AssetLocationTracker> getLocations() {
		return getMongoTemplate().findAll(AssetLocationTracker.class);
	}

	@Override
	public void saveHistory(TrackingHistory trackingHistory) {
		getMongoTemplate().insert(trackingHistory);
	}

	@Override
	public List<TrackingHistory> getConsolidatedPings(DateTime fromTime, DateTime toTime) {
		Query query = new Query();
		query = query.addCriteria(where("dateTime").gte(fromTime).lte(toTime));
		return getMongoTemplate().findAll(TrackingHistory.class);
	}

	private MongoTemplate getMongoTemplate() {
		if(mongoTemplate == null) {
			MongoConfig applicationConfig = new MongoConfig();
			try {
				return applicationConfig.mongoTemplate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mongoTemplate;
	}
}
