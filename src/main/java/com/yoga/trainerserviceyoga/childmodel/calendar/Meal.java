package com.yoga.trainerserviceyoga.childmodel.calendar;

import java.util.List;

import com.yoga.trainerserviceyoga.model.NutritionMealModel;

public class Meal {
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
	private List<NutritionMealModel> foodItems;
	private Macros macros;

	public Macros getMacros() {
		return macros;
	}

	public void setMacros(Macros macros) {
		this.macros = macros;
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

	public List<NutritionMealModel> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<NutritionMealModel> foodItems) {
		this.foodItems = foodItems;
	}

}
