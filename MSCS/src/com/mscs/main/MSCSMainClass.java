package com.mscs.main;

import java.util.HashMap;
import java.util.Map;

import com.mscs.logic.MSCSFareCalculation;
import com.mscs.logic.MSCSReport;
import com.mscs.stations.StationDetails;
import com.mscs.user.UserDetails;

public class MSCSMainClass {

	public static void main(String a[]) {
		StationDetails stationObj = new StationDetails();
		MSCSFareCalculation fareObj = new MSCSFareCalculation();
		MSCSReport reportObj = new MSCSReport();
		
		UserDetails user1 = new UserDetails(1001,"Gaurav",200.00);
		UserDetails user2 = new UserDetails(1002,"Garg",200.00);
		
		Map stationMap = new HashMap();
		Map stationMapCount = new HashMap();
		stationMap = stationObj.getStationDetails();
		stationMapCount = stationObj.getStationSwipeDetails();
	
		stationMapCount = fareObj.journeyDetails
				(user1, "A1", "A6", stationMap,stationMapCount);
		
		stationMapCount = fareObj.journeyDetails(user1, "A1", "A8", stationMap,stationMapCount);
		stationMapCount = fareObj.journeyDetails(user1, "A3", "A6", stationMap,stationMapCount);
		stationMapCount = fareObj.journeyDetails(user1, "A4", "A8", stationMap,stationMapCount);
		stationMapCount = fareObj.journeyDetails(user1, "A7", "A1", stationMap,stationMapCount);
		stationMapCount = fareObj.journeyDetails(user1, "A2", "A6", stationMap,stationMapCount);
		stationMapCount = fareObj.journeyDetails(user1, "A4", "A8", stationMap,stationMapCount);
		stationMapCount = fareObj.journeyDetails(user1, "A7", "A1", stationMap,stationMapCount);
		stationMapCount = fareObj.journeyDetails(user1, "A2", "A6", stationMap,stationMapCount);
		
		
		stationMapCount = fareObj.journeyDetails(user2, "A1", "A5", stationMap,stationMapCount);
		stationMapCount = fareObj.journeyDetails(user2, "A8", "A3", stationMap,stationMapCount);
		stationMapCount = fareObj.journeyDetails(user2, "A7", "A4", stationMap,stationMapCount);
		stationMapCount = fareObj.journeyDetails(user2, "A2", "A10", stationMap,stationMapCount);
		
		reportObj.GenerateSwipeRecords(stationMapCount);
		
	}
}
