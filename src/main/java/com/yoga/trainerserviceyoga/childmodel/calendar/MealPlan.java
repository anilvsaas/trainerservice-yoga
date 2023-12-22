package com.yoga.trainerserviceyoga.childmodel.calendar;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "master_mealplans")
public class MealPlan {
	@Id
	private String mealId;
	private Meal breakfast;
	private Meal lunch;
	private Meal snacks;
	private Meal dinner;
	private double overall_protein_recommended;
	private double overall_carboHydrate_recommended;
	private double overall_fibre_recommended;
	private double overall_fat_recommended;
	private double overall_calories_recommended;
	private double overall_protein_consumed;
	private double overall_carboHydrate_consumed;
	private double overall_fibre_consumed;
	private double overall_fat_consumed;
	private double overall_calories_consumed;
	private String mealPlanStatus;
	private Object waterConsumed;
	private String mealName;
	private Macros macros;
	private String trainerId;
	private Date createdOn;
	private Date lastUpdatedOn;

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public String getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	public String getMealId() {
		return mealId;
	}

	public void setMealId(String mealId) {
		this.mealId = mealId;
	}

	public Macros getMacros() {
		return macros;
	}

	public void setMacros(Macros macros) {
		this.macros = macros;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public Meal getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(Meal breakfast) {
		this.breakfast = breakfast;
	}

	public Meal getLunch() {
		return lunch;
	}

	public void setLunch(Meal lunch) {
		this.lunch = lunch;
	}

	public Meal getSnacks() {
		return snacks;
	}

	public void setSnacks(Meal snacks) {
		this.snacks = snacks;
	}

	public Meal getDinner() {
		return dinner;
	}

	public void setDinner(Meal dinner) {
		this.dinner = dinner;
	}

	public double getOverall_protein_recommended() {
		return overall_protein_recommended;
	}

	public void setOverall_protein_recommended(double overall_protein_recommended) {
		this.overall_protein_recommended = overall_protein_recommended;
	}

	public double getOverall_carboHydrate_recommended() {
		return overall_carboHydrate_recommended;
	}

	public void setOverall_carboHydrate_recommended(double overall_carboHydrate_recommended) {
		this.overall_carboHydrate_recommended = overall_carboHydrate_recommended;
	}

	public double getOverall_fibre_recommended() {
		return overall_fibre_recommended;
	}

	public void setOverall_fibre_recommended(double overall_fibre_recommended) {
		this.overall_fibre_recommended = overall_fibre_recommended;
	}

	public double getOverall_fat_recommended() {
		return overall_fat_recommended;
	}

	public void setOverall_fat_recommended(double overall_fat_recommended) {
		this.overall_fat_recommended = overall_fat_recommended;
	}

	public double getOverall_calories_recommended() {
		return overall_calories_recommended;
	}

	public void setOverall_calories_recommended(double overall_calories_recommended) {
		this.overall_calories_recommended = overall_calories_recommended;
	}

	public double getOverall_protein_consumed() {
		return overall_protein_consumed;
	}

	public void setOverall_protein_consumed(double overall_protein_consumed) {
		this.overall_protein_consumed = overall_protein_consumed;
	}

	public double getOverall_carboHydrate_consumed() {
		return overall_carboHydrate_consumed;
	}

	public void setOverall_carboHydrate_consumed(double overall_carboHydrate_consumed) {
		this.overall_carboHydrate_consumed = overall_carboHydrate_consumed;
	}

	public double getOverall_fibre_consumed() {
		return overall_fibre_consumed;
	}

	public void setOverall_fibre_consumed(double overall_fibre_consumed) {
		this.overall_fibre_consumed = overall_fibre_consumed;
	}

	public double getOverall_fat_consumed() {
		return overall_fat_consumed;
	}

	public void setOverall_fat_consumed(double overall_fat_consumed) {
		this.overall_fat_consumed = overall_fat_consumed;
	}

	public double getOverall_calories_consumed() {
		return overall_calories_consumed;
	}

	public void setOverall_calories_consumed(double overall_calories_consumed) {
		this.overall_calories_consumed = overall_calories_consumed;
	}

	public String getMealPlanStatus() {
		return mealPlanStatus;
	}

	public void setMealPlanStatus(String mealPlanStatus) {
		this.mealPlanStatus = mealPlanStatus;
	}

	public Object getWaterConsumed() {
		return waterConsumed;
	}

	public void setWaterConsumed(Object waterConsumed) {
		this.waterConsumed = waterConsumed;
	}

}
