package com.yoga.trainerserviceyoga.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.yoga.trainerserviceyoga.childmodel.calendar.MealPlan;



@Document(collection = "self_mealplans")
public class SelfMealPlan {
	@Id
	private String mealplan_id;
	private String trainee_id;
	private String date;
	private MealPlan mealplan;
	private Date creationDate;
	private Date lastUpdatedDate;

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public MealPlan getMealplan() {
		return mealplan;
	}

	public void setMealplan(MealPlan mealplan) {
		this.mealplan = mealplan;
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

}
