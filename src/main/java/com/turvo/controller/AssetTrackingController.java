package com.turvo.controller;

import com.turvo.model.AssetLocationTracker;
import com.turvo.model.LocationInfo;
import com.turvo.model.TrackingHistory;
import com.turvo.service.AssetTrackingService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssetTrackingController {

	@Autowired
	AssetTrackingService assetTrackingService;

	@RequestMapping(value="/asset/save",method = RequestMethod.POST)
	public ResponseEntity<String> captureAssetInformation(@RequestBody AssetLocationTracker assetLocationTracker) {
		assetTrackingService.saveAssetTracker(assetLocationTracker);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value="/locations",method = RequestMethod.GET)
	public List<LocationInfo> getLocations() {
		return assetTrackingService.getLocations();
	}

	@RequestMapping(value="/pings",method = RequestMethod.GET)
	public List<TrackingHistory> getConsolidatedPings(@RequestParam("fromTime") @DateTimeFormat(pattern="yyyy-MM-dd") DateTime fromTime, @RequestParam("toTime") @DateTimeFormat(pattern="yyyy-MM-dd") DateTime toTime) {
		return assetTrackingService.getConsolidatedPings(fromTime, toTime);
	}
}
