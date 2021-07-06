package com.bms.model;

public enum RateOfInterest {
	EDUCATION(0.75), PERSONAL(2), HOME(1.5);

	public final double rateOfInterest;

	private RateOfInterest(double rate) {
		this.rateOfInterest = rate;
	}

	public double getRateOfInterest() {
		return this.rateOfInterest;
	}
}
