package com.yoga.trainerserviceyoga.childmodel;

import java.util.List;

public class ProgramSlot {
	private int id;
	private List<CommonReferenceModel> startTime;
	private List<CommonReferenceModel> endTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<CommonReferenceModel> getStartTime() {
		return startTime;
	}

	public void setStartTime(List<CommonReferenceModel> startTime) {
		this.startTime = startTime;
	}

	public List<CommonReferenceModel> getEndTime() {
		return endTime;
	}

	public void setEndTime(List<CommonReferenceModel> endTime) {
		this.endTime = endTime;
	}

}
