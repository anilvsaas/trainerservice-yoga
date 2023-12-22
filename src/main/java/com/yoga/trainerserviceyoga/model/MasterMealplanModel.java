package com.yoga.trainerserviceyoga.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.yoga.trainerserviceyoga.childmodel.calendar.MealplanWeek;



@Document(collection = "yoga_master_trainee_mealplans")
public class MasterMealplanModel {
	@Id
	private String mealplan_id;
	private String trainee_id;
	private String trainer_id;
	private List<MealplanWeek> weeks;
	private Date creationDate;
	private String program_id;
	private Date lastUpdatedDate;

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getProgram_id() {
		return program_id;
	}

	public void setProgram_id(String program_id) {
		this.program_id = program_id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getMealplan_id() {
		return mealplan_id;
	}

	public void setMealplan_id(String mealplan_id) {
		this.mealplan_id = mealplan_id;
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

	public List<MealplanWeek> getWeeks() {
		return weeks;
	}

	public void setWeeks(List<MealplanWeek> weeks) {
		this.weeks = weeks;
	}

}
