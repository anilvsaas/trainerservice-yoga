package com.yoga.trainerserviceyoga.childmodel.calendar;

import java.util.List;

public class CalendarWeek {
	private int week;
	private List<CalendarDay> days;
	private String weekPercentage;
	private String weekStatus;
	public String getWeekStatus() {
		return weekStatus;
	}

	public void setWeekStatus(String weekStatus) {
		this.weekStatus = weekStatus;
	}

	public String getWeekPercentage() {
		return weekPercentage;
	}

	public void setWeekPercentage(String weekPercentage) {
		this.weekPercentage = weekPercentage;
	}

	public List<CalendarDay> getDays() {
		return days;
	}

	public void setDays(List<CalendarDay> days) {
		this.days = days;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	

}
