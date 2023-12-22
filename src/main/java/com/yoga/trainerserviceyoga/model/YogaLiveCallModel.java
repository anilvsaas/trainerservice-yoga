package com.yoga.trainerserviceyoga.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.yoga.trainerserviceyoga.childmodel.CommonReferenceModel;
import com.yoga.trainerserviceyoga.childmodel.Slot;


@Document(collection="yoga_live_calls")
public class YogaLiveCallModel {
	@Id
	private String schedulerId;
	private Date date;
	private CommonReferenceModel frequency;
	private CommonReferenceModel delay;
	private String title;
	private String trainerId;
	private List<Slot> slots;
	private String month;
	private String timezone;
	private Date creationDate;
	private Date lastUpdatedDate;

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

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getSchedulerId() {
		return schedulerId;
	}

	public void setSchedulerId(String schedulerId) {
		this.schedulerId = schedulerId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public CommonReferenceModel getFrequency() {
		return frequency;
	}

	public void setFrequency(CommonReferenceModel frequency) {
		this.frequency = frequency;
	}

	public CommonReferenceModel getDelay() {
		return delay;
	}

	public void setDelay(CommonReferenceModel delay) {
		this.delay = delay;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	public List<Slot> getSlots() {
		return slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}
}
