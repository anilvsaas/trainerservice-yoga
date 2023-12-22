package com.yoga.trainerserviceyoga.model;

import java.util.Date;


import java.util.List;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.yoga.trainerserviceyoga.childmodel.calendar.CalendarWeek;


@Document(collection = "trainee_yoga_calendars")
public class TraineeCalendarModel {
	private String program_id;
	private String trainee_id;
	private String trainer_id;
	private String calendar_id;
	private Date endDate;
	private List<CalendarWeek> weeks;
	private Date creationDate;
	private Date lastUpdatedDate;
	private Integer idleFor;
	private String trainer_status;
	private Date startDate;
	@Transient
	private Date subscriptionDate;
	private boolean isSlaCrossed;

	public boolean getIsSlaCrossed() {
		return isSlaCrossed;
	}

	public void setIsSlaCrossed(boolean isSlaCrossed) {
		this.isSlaCrossed = isSlaCrossed;
	}
	
	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getTrainer_status() {
		return trainer_status;
	}

	public void setTrainer_status(String trainer_status) {
		this.trainer_status = trainer_status;
	}

	

	
	public String getProgram_id() {
		return program_id;
	}

	public void setProgram_id(String program_id) {
		this.program_id = program_id;
	}

	public String getTrainee_id() {
		return trainee_id;
	}

	public void setTrainee_id(String trainee_id) {
		this.trainee_id = trainee_id;
	}

	public String getTrainer_id() {
		return trainer_id;
	}

	public void setTrainer_id(String trainer_id) {
		this.trainer_id = trainer_id;
	}

	public String getCalendar_id() {
		return calendar_id;
	}

	public void setCalendar_id(String calendar_id) {
		this.calendar_id = calendar_id;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<CalendarWeek> getWeeks() {
		return weeks;
	}

	public void setWeeks(List<CalendarWeek> weeks) {
		this.weeks = weeks;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Integer getIdleFor() {
		return idleFor;
	}

	public void setIdleFor(Integer idleFor) {
		this.idleFor = idleFor;
	}

}
