# turvo-locationtracker
Location Tracker Application built using Spring Boot with REST webservices and MongoDB.

# Rest Calls
----------------
1)/asset/save
This call will save AssetTracker information based on tracker type
 a) if it is Vehicle then it will populate vehicle details along with location,latitude,longitude etc.
 b) if it is Mobile type then it will populate mobile details like deviceid,mobilenumber,vehiclenum etc.
 c) this will also save tracking details like trackerType,deviceId,driverId for history purposes.

2)/locations
 This call will fetch all the saved locations which contains location,vehiclespeed,latitude,longitude,driverid,
 deviceid etc

3)/pings
This call will fetch the number of pings(from trackerhistory table) where it contains entries of each saved asset tracker.
For a given time frame (fromTime and toTime) it will fetch the history details.


# Database Model:
-----------------
We have used MongoDB and the database model is located at : /src/main/datamodel.

NOTE :
There is no UI for this application, hence using POSTMAN we can hit the respective URLs and test the functionality.
