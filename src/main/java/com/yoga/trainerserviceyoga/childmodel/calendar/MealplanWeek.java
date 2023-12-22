package com.yoga.trainerserviceyoga.childmodel.calendar;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class MealplanWeek {
	private List<MealPlanDay> days;
    private int week;
	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public List<MealPlanDay> getDays() {
		return days;
	}

	public void setDays(List<MealPlanDay> days) {
		this.days = days;
	}
}
