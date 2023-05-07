package com.gaurav.cabImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.gaurav.cab.CabDetails;

public class CabOperations {

	public Set<CabDetails> getCabInformation() {
		Set<CabDetails> cabInfo = new HashSet<>();
		String csvFile = "Data.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] cab = line.split(cvsSplitBy);
				cabInfo.add(new CabDetails(cab[0], cab[1], cab[2]));
				System.out.println("Cab details : " + cab[0] + " , " + cab[1]);
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
		return cabInfo;
	}

	public Set<String> confirmCabBooking
	(Set<CabDetails> cabInfo, Set<String> bookedCab) {
		boolean validateBooking = validateCabAvailabiliy(cabInfo);
		System.out.println("************* Booking Cab ***************");
		Iterator<CabDetails> iterator = cabInfo.iterator();
		if (validateBooking) {
			while (iterator.hasNext()) {
				CabDetails cab = iterator.next();
				if (cab.getCabAvailable().equalsIgnoreCase("Y")) {
					bookedCab.add(cab.getCabId());
					System.out.println("Cab " + cab.getCabType() + " booked with cab Id : " + cab.getCabId());
					cab.setCabAvailable("N");
					break;
				}
			}
		} else {
			System.out.println("No Cabs available for booking.");
		}
		System.out.println("Booked Cabs : " + bookedCab);
		System.out.println("*****************************************");
		System.out.println();
		return bookedCab;
	}

	public Set<String> cancelCabBooking(String cabId, Set<CabDetails> cabInfo, Set<String> bookedCab) {
		System.out.println("************* Cancelling Cab ***************");
		if (bookedCab.contains(cabId)) {
			Iterator<CabDetails> iterator = cabInfo.iterator();
			while (iterator.hasNext()) {
				CabDetails cab = iterator.next();
				if (cab.getCabId().equalsIgnoreCase(cabId)) {
					bookedCab.remove(cab.getCabId());
					System.out.println("Cab " + cab.getCabType() + " cancelled with cab Id : " + cab.getCabId());
					cab.setCabAvailable("Y");
					break;
				}
			}
			System.out.println("Booked Cabs : " + bookedCab);
			System.out.println();
		} else {
			System.out.println("Invalid Cab Id : " + cabId);
		}
		System.out.println("*****************************************");
		System.out.println();
		return bookedCab;
	}

	public List<String> getAvailableCabDetails(Set<CabDetails> cabInfo) {
		List<String> availableCab = new ArrayList<>();

		Iterator<CabDetails> iterator = cabInfo.iterator();
		while (iterator.hasNext()) {
			CabDetails cab = iterator.next();
			if (cab.getCabAvailable().equalsIgnoreCase("Y")) {
				availableCab.add(cab.getCabId());
				continue;
			}
		}
		System.out.println("Available Cab pool : " + availableCab);
		System.out.println();
		return availableCab;
	}

	public boolean validateCabAvailabiliy(Set<CabDetails> cabInfo) {

		boolean validateFlag = false;
		Iterator<CabDetails> iterator = cabInfo.iterator();
		while (iterator.hasNext()) {
			CabDetails cab = iterator.next();
			if (cab.getCabAvailable().equalsIgnoreCase("Y")) {
				validateFlag = true;
				break;
			}
		}
		return validateFlag;
	}
}
