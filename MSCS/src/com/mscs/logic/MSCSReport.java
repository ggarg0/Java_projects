package com.mscs.logic;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MSCSReport {

	public void GenerateSwipeRecords(Map<String, Integer> stationMapCount) {

		System.out
				.println("\n-------------- Station Swipe Records -----------------\n");

		System.out.println();
		Set<String> set = stationMapCount.keySet();
		Iterator<String> iterator = set.iterator();

		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			System.out.print(key + " = ");
			System.out.println((Integer) stationMapCount.get(key));
		}

		System.out
				.println("\n-------------- -------------- -----------------\n");
	}

}
