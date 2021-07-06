package com.bms.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class RateOfInterestTest {

//	@Test
//	void testGetRateOfInterest() {
//		fail("Not yet implemented");
//	}

	@Test
	void testRateOfInterestEducation() {
		assertEquals(0.75, RateOfInterest.EDUCATION.rateOfInterest);
	}
	@Test
	void testRateOfInterestPersonal() {
		assertEquals(2, RateOfInterest.PERSONAL.rateOfInterest);
	}
	@Test
	void testRateOfInterestHome() {
		assertEquals(1.5, RateOfInterest.HOME.rateOfInterest);
	}
}
