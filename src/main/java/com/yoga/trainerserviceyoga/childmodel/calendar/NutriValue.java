package com.yoga.trainerserviceyoga.childmodel.calendar;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class NutriValue {
	//private float per_serving;
	private double recommended;
	private double consumed;
	
//	public float getPer_serving() {
//		return per_serving;
//	}
//	public void setPer_serving(float per_serving) {
//		this.per_serving = per_serving;
//	}
	public double getRecommended() {
		return recommended;
	}
	public void setRecommended(double recommended) {
		this.recommended = recommended;
	}
	public double getConsumed() {
		return consumed;
	}
	public void setConsumed(double consumed) {
		this.consumed = consumed;
	}
	
}
