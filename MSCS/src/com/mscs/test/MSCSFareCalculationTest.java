package com.mscs.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.mscs.logic.MSCSFareCalculation;

public class MSCSFareCalculationTest {

	MSCSFareCalculation obj;
	double balance;
	double fare;
/*
	@Before
	public void before() {
		obj = new MSCSFareCalculation();
		balance = 50.0;
		fare = 20.0;
	}

	@After
	public void after() {

		obj = null;

	}

	@Test
	public void testCalcualteMinimumBalance() {
		assertEquals(true, obj.calcualteMinimumBalance(balance));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCalculateRemainingBalance() {
		double expectedValue = 30.0;
		assertEquals(expectedValue,
				obj.calculateRemainingBalance(balance, fare), 0.0);
	}

	@Test
	public void testCalculateFare() {
		double expectedValue = 28.0;
		assertEquals(expectedValue, obj.calculateFare(4, "ABC"), 0.0);
	}

	@Test
	public void testCalculateNumberOfStations() {
		int expectedValue = 8;
		assertEquals(expectedValue, obj.calculateNumberOfStations("A1", "A8"));
	}
*/
}
