package com.mscs.logic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.*;

public class MSCSReport {

	public void GenerateSwipeRecords(Map stationMapCount) {

		System.out
				.println("\n-------------- Station Swipe Records -----------------\n");

		System.out.println();
		Set set = stationMapCount.keySet();
		Iterator iterator = set.iterator();

		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			System.out.print(key + " = ");
			System.out.println((Integer) stationMapCount.get(key));
		}

		System.out
				.println("\n-------------- -------------- -----------------\n");
	}

}
