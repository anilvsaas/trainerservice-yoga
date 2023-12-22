package com.yoga.trainerserviceyoga.childmodel.calendar;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class MealPlanDay {
	private String date;
	private int day;
	private String program_id;
	private String trainee_id;
	private MealPlan mealplan;
	private String trainer_status;
	

	public String getTrainer_status() {
		return trainer_status;
	}

	public void setTrainer_status(String trainer_status) {
		this.trainer_status = trainer_status;
	}

	public MealPlan getMealplan() {
		return mealplan;
	}

	public void setMealplan(MealPlan mealplan) {
		this.mealplan = mealplan;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	
}
