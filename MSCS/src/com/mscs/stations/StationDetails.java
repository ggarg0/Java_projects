package com.mscs.stations;

import java.util.HashMap;
import java.util.Map;

public class StationDetails {

	public Map<String, Integer> getStationDetails()
	{
		Map<String, Integer> stationMap = new HashMap<String, Integer>();
		stationMap.put("A1", 1);
		stationMap.put("A2", 2);
		stationMap.put("A3", 3);
		stationMap.put("A4", 4);
		stationMap.put("A5", 5);
		stationMap.put("A6", 6);
		stationMap.put("A7", 7);
		stationMap.put("A8", 8);
		stationMap.put("A9", 9);
		stationMap.put("A10",10);
		stationMap.put("A11",11);
		return stationMap;
	}
	
	public Map<String, Integer> getStationSwipeDetails()
	{
		Map<String, Integer> stationMapCount = new HashMap<String, Integer>();
		stationMapCount.put("A1", 0);
		stationMapCount.put("A2", 0);
		stationMapCount.put("A3", 0);
		stationMapCount.put("A4", 0);
		stationMapCount.put("A5", 0);
		stationMapCount.put("A6", 0);
		stationMapCount.put("A7", 0);
		stationMapCount.put("A8", 0);
		stationMapCount.put("A9", 0);
		stationMapCount.put("A10",0);
		stationMapCount.put("A11",0);
		return stationMapCount;
	}
	
}
