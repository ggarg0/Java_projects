package com.gaurav.main;

import java.util.HashSet;
import java.util.Set;

import com.gaurav.cab.CabDetails;
import com.gaurav.cabImpl.CabOperations;

public class BookACab {

	public static void main(String[] args) {
		try {
			Set<String> bookedCab = new HashSet<>();
			CabOperations cabbie = new CabOperations();

			Set<CabDetails> cabInfo = cabbie.getCabInformation();

			bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);
			bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);
			bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);
			bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);
			bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);
			bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);

			cabbie.getAvailableCabDetails(cabInfo);

			bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);
			bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);
			bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);
			bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);
			bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);

			cabbie.getAvailableCabDetails(cabInfo);
			bookedCab = cabbie.cancelCabBooking("10005", cabInfo, bookedCab);

			bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);
			bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);
			bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);

			bookedCab = cabbie.cancelCabBooking("10004", cabInfo, bookedCab);
			cabbie.getAvailableCabDetails(cabInfo);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
	}
}
