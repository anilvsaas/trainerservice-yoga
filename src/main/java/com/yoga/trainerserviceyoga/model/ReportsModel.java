package com.yoga.trainerserviceyoga.model;

import java.util.List;

import com.yoga.trainerserviceyoga.childmodel.ChartModel;

public class ReportsModel {
	
	private String name;
	private List<ChartModel> series;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ChartModel> getSeries() {
		return series;
	}
	public void setSeries(List<ChartModel> series) {
		this.series = series;
	}

}
