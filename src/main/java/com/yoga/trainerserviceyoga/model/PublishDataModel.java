package com.yoga.trainerserviceyoga.model;

import java.util.Date;

public class PublishDataModel {
	private String trainer_id;
	private String trainee_id;
	private String program_id;
	private Date start_date;
	private String trainer_status;
	private boolean isSlaCrossed;

	public boolean getIsSlaCrossed() {
	return isSlaCrossed;
	}

	public void setIsSlaCrossed(boolean isSlaCrossed) {
	this.isSlaCrossed = isSlaCrossed;
	}

	public String getTrainer_status() {
		return trainer_status;
	}

	public void setTrainer_status(String trainer_status) {
		this.trainer_status = trainer_status;
	}

	public String getTrainer_id() {
		return trainer_id;
	}

	public void setTrainer_id(String trainer_id) {
		this.trainer_id = trainer_id;
	}

	public String getTrainee_id() {
		return trainee_id;
	}

	public void setTrainee_id(String trainee_id) {
		this.trainee_id = trainee_id;
	}

	public String getProgram_id() {
		return program_id;
	}

	public void setProgram_id(String program_id) {
		this.program_id = program_id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

}
