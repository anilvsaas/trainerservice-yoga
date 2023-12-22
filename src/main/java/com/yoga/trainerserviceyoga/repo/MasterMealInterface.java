package com.yoga.trainerserviceyoga.repo;

import java.util.List;

import com.yoga.trainerserviceyoga.childmodel.calendar.MealPlan;


public interface MasterMealInterface {
	public String saveMealPlan(MealPlan mealplan);

	public MealPlan getMealPlan(String mealId);

	public MealPlan updateMealPlan(MealPlan mealplan);

	public List<MealPlan> getMealPlans(String trainerId);

	public void deleteMasterMeal(String mealId);
}
