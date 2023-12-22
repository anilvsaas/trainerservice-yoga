package com.yoga.trainerserviceyoga.childmodel.profile;

import java.util.Date;

public class Bmi_bmr {
	private Date lastUpdatedOn;
	private double bmi_value;
	private double bmr_value;
	

	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public double getBmi_value() {
		return bmi_value;
	}

	public void setBmi_value(double bmi_value) {
		this.bmi_value = bmi_value;
	}

	public double getBmr_value() {
		return bmr_value;
	}

	public void setBmr_value(double bmr_value) {
		this.bmr_value = bmr_value;
	}
	

	
}
