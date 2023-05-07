package com.mscs.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.mscs.logic.MSCSFareCalculation;
import com.mscs.logic.MSCSReport;
import com.mscs.stations.StationDetails;
import com.mscs.user.Employee;
import com.mscs.user.NonEmployee;
import com.mscs.user.User;

public class MSCSMainClass {

	Set<User> users = new HashSet<User>();

	public static void main(String a[]) {
		StationDetails stationObj = new StationDetails();
		MSCSFareCalculation fareObj = new MSCSFareCalculation();
		MSCSReport reportObj = new MSCSReport();

		User user1 = new User(1001, "Tom", 200.00);
		User user2 = new User(1002, "Harry", 200.00);

		Map<String, Integer> stationMap = new HashMap<String, Integer>();
		Map<String, Integer> stationMapCount = new HashMap<String, Integer>();
		stationMap = stationObj.getStationDetails();
		stationMapCount = stationObj.getStationSwipeDetails();

		stationMapCount = fareObj.journeyDetails(user1, "A1", "A6", stationMap, stationMapCount);

		stationMapCount = fareObj.journeyDetails(user1, "A1", "A8", stationMap, stationMapCount);
		stationMapCount = fareObj.journeyDetails(user1, "A3", "A6", stationMap, stationMapCount);
		stationMapCount = fareObj.journeyDetails(user1, "A4", "A8", stationMap, stationMapCount);
		stationMapCount = fareObj.journeyDetails(user1, "A7", "A1", stationMap, stationMapCount);
		stationMapCount = fareObj.journeyDetails(user1, "A2", "A6", stationMap, stationMapCount);
		stationMapCount = fareObj.journeyDetails(user1, "A4", "A8", stationMap, stationMapCount);
		stationMapCount = fareObj.journeyDetails(user1, "A7", "A1", stationMap, stationMapCount);
		stationMapCount = fareObj.journeyDetails(user1, "A2", "A6", stationMap, stationMapCount);

		stationMapCount = fareObj.journeyDetails(user2, "A1", "A5", stationMap, stationMapCount);
		stationMapCount = fareObj.journeyDetails(user2, "A8", "A3", stationMap, stationMapCount);
		stationMapCount = fareObj.journeyDetails(user2, "A7", "A4", stationMap, stationMapCount);
		stationMapCount = fareObj.journeyDetails(user2, "A2", "A10", stationMap, stationMapCount);

		reportObj.GenerateSwipeRecords(stationMapCount);

	}

	public void loadAllUsers() {
		String csvFile = "Data.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] user = line.split(cvsSplitBy);
				if (user[4].equalsIgnoreCase("Yes")) {
					users.add(new Employee(Integer.parseInt(user[0]), user[1], Double.parseDouble(user[2]), 0, true));
				} else {
					users.add(new NonEmployee(Integer.parseInt(user[0]), user[1], Double.parseDouble(user[2]),
							Integer.parseInt(user[3]), false));
				}
			}
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("Exception : " + e);
				}
			}
		}
	}
}
