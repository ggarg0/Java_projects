package com.mscs.logic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.mscs.user.User;

public class MSCSFareCalculation {

	public Map<String, Integer> journeyDetails(User user, String startStation,
			String endStation, Map<String, Integer> stationMap, Map<String, Integer> stationMapCount) {
		boolean minimumBalanceAvailable = calcualteMinimumBalance(user);
		if (minimumBalanceAvailable) {
			stationMapCount = calculateSwipeCount(startStation, endStation,
					stationMapCount);

			int noOfStations = calculateNumberOfStations(startStation,
					endStation, stationMap);
			System.out.println("No of Stations is " + noOfStations + " from "
					+ startStation + " to " + endStation);

			double fare = calculateFare(noOfStations);
			System.out.println("fare : " + fare);

			if (user.getUserBalance() < 50) {
				System.out
						.println("You Do not have enoungh funds on your card."
								+ "\nPlease wait for assisntance."
								+ "\nYour balance is : "
								+ user.getUserBalance());

				System.out
						.println("-------------- -------------- -----------------\n");
			} else {
				user = calculateRemainingBalance(user, fare);
				System.out.println("Thank you for travelling with MSCS."
						+ "\nYour balance is : " + user.getUserBalance());
				System.out.println("Transactions end for card number :  "
						+ user.getUserCardId() + "\n");
				System.out
						.println("-------------- -------------- -----------------\n");
			}

		} else {
			System.out.println("Please recharge your card : "
					+ user.getUserCardId() + " for travelling with MSCS."
					+ "\nBalance Available : " + user.getUserBalance());
			System.out.println("Transactions end for card number :  "
					+ user.getUserCardId() + "\n");
			System.out
					.println("-------------- -------------- -----------------\n");
		}
		return stationMapCount;
	}

	public boolean calcualteMinimumBalance(User User) {

		if (User.getUserBalance() > 50) {
			return true;
		} else {
			return false;
		}
	}

	public User calculateRemainingBalance(User user, double fare) {
		user.setUserBalance(user.getUserBalance() - fare);
		return user;
	}

	public double calculateFare(int noOfStations) {

		double fare;
		double weekendFare = 5.5;
		double weekdayFare = 7;

		Calendar cal = Calendar.getInstance();
		String Day = (new SimpleDateFormat("EEE").format(cal.getTime()));

		if (Day.equalsIgnoreCase("sat") || Day.equalsIgnoreCase("sun")) {
			fare = noOfStations * weekendFare;
		} else {
			fare = noOfStations * weekdayFare;
		}
		return fare;
	}

	public int calculateNumberOfStations(String startStation,
			String endStation, Map<String, Integer> stationMap) {

		int numberOfStations = 0;
		int startStationNum = 0;
		int endStationNum = 0;

		Set<String> set = stationMap.keySet();
		Iterator<String> iterator = set.iterator();

		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			if (key.equalsIgnoreCase(startStation)) {
				startStationNum = (Integer) stationMap.get(key);
			} else if (key.equalsIgnoreCase(endStation)) {
				endStationNum = (Integer) stationMap.get(key);
			}
		}

		if (startStationNum > endStationNum) {
			numberOfStations = (startStationNum - endStationNum);
		} else {
			numberOfStations = (endStationNum - startStationNum);
		}

		return numberOfStations;
	}

	public Map<String, Integer> calculateSwipeCount(String startStation, String endStation,
			Map<String, Integer> stationMapCount) {

		Set<String> set = stationMapCount.keySet();
		Iterator<String> iterator = set.iterator();

		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			if (key.equalsIgnoreCase(startStation)
					|| key.equalsIgnoreCase(endStation)) {
				stationMapCount
						.put(key, (Integer) stationMapCount.get(key) + 1);
			}
		}
		return stationMapCount;
	}
}
