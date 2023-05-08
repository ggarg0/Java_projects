package com.mscs.stations;

import java.util.HashMap;
import java.util.Map;

public class StationDetails {

	public Map<String, Integer> getStationDetails()
	{
		Map<String, Integer> stationMap = new HashMap<String, Integer>();
		stationMap.put("A1", 5);
		stationMap.put("A2", 9);
		stationMap.put("A3", 14);
		stationMap.put("A4", 19);
		stationMap.put("A5", 24);
		stationMap.put("A6", 28);
		stationMap.put("A7", 33);
		stationMap.put("A8", 38);
		stationMap.put("A9", 45);
		stationMap.put("A10",52);
		stationMap.put("A11",58);
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
