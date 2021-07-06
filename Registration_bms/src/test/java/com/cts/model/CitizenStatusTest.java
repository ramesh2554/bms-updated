package com.cts.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CitizenStatusTest {

	@Test
	void testCitizenStatusMinor() {
		assertEquals("MINOR", CitizenStatus.MINOR.name());
	}
	@Test
	void testCitizenStatusNormal() {
		assertEquals("NORMAL", CitizenStatus.NORMAL.name());
	}
	@Test
	void testCitizenStatusSenior() {
		assertEquals("SENIOR", CitizenStatus.SENIOR.name());
	}
}
