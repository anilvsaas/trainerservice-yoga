package com.yoga.trainerserviceyoga.model;

import java.util.Date;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.yoga.trainerserviceyoga.childmodel.calendar.CalendarWeek;

@Document(collection = "yoga_calendars")
public class CalendarModel {
	@Id
	private String calendarId;
	private String programId;
	private String trainerId;
	private Date startDate;
	private Date endDate;
	@NotNull(message = "Please provide calendar data")
	private List<CalendarWeek> weeks;
	private Date creationDate;
	private Date lastUpdatedDate;
	private Integer idleFor;
	private String adminStatus;

	
	public String getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}

	public String getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(String calendarId) {
		this.calendarId = calendarId;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	
	public List<CalendarWeek> getWeeks() {
		return weeks;
	}

	public void setWeeks(List<CalendarWeek> weeks) {
		this.weeks = weeks;
	}


}
