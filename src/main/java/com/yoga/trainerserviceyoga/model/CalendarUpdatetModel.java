package com.yoga.trainerserviceyoga.model;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yoga.trainerserviceyoga.childmodel.Comment;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CalendarUpdatetModel {
	private String workoutStatus;
	private String exerciseStatus;
	private String calendar_id;
	private String date;
	private String workoutId;
	private String trainee_id;
	private List<Object> sets;
	private String workoutPercentage;
	private String exercisePercentage;
	private int week;
	private int day;
	private int exercise_referenceId;
	private String program_id;
	private String cardioStatus;
	private int foodCode;
	private Object mealplan;
	private String mealPlanStatus;
	private String foodStatus;
	private String mealType;
	private int consumedQuantity;
	private String nutrientType;
	private List<Object> foodItems;
	private Object waterConsumed;
	private Comment workoutComment;
	private Comment exerciseComment;
	private Comment cardioComment;
	
	public Comment getWorkoutComment() {
		return workoutComment;
	}
	public void setWorkoutComment(Comment workoutComment) {
		this.workoutComment = workoutComment;
	}
	public Comment getExerciseComment() {
		return exerciseComment;
	}
	public void setExerciseComment(Comment exerciseComment) {
		this.exerciseComment = exerciseComment;
	}
	public Comment getCardioComment() {
		return cardioComment;
	}
	public void setCardioComment(Comment cardioComment) {
		this.cardioComment = cardioComment;
	}
	

	public Object getWaterConsumed() {
		return waterConsumed;
	}
	public void setWaterConsumed(Object waterConsumed) {
		this.waterConsumed = waterConsumed;
	}
	public List<Object> getFoodItems() {
		return foodItems;
	}
	public void setFoodItems(List<Object> foodItems) {
		this.foodItems = foodItems;
	}
	public String getNutrientType() {
		return nutrientType;
	}
	public void setNutrientType(String nutrientType) {
		this.nutrientType = nutrientType;
	}
	public int getConsumedQuantity() {
		return consumedQuantity;
	}
	public void setConsumedQuantity(int consumedQuantity) {
		this.consumedQuantity = consumedQuantity;
	}
	public String getMealPlanStatus() {
		return mealPlanStatus;
	}
	public void setMealPlanStatus(String mealPlanStatus) {
		this.mealPlanStatus = mealPlanStatus;
	}
	public String getFoodStatus() {
		return foodStatus;
	}
	public void setFoodStatus(String foodStatus) {
		this.foodStatus = foodStatus;
	}
	public String getMealType() {
		return mealType;
	}
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
	
	public Object getMealplan() {
		return mealplan;
	}
	public void setMealplan(Object mealplan) {
		this.mealplan = mealplan;
	}
	public int getFoodCode() {
		return foodCode;
	}
	public void setFoodCode(int foodCode) {
		this.foodCode = foodCode;
	}
	public String getCardioStatus() {
		return cardioStatus;
	}
	public void setCardioStatus(String cardioStatus) {
		this.cardioStatus = cardioStatus;
	}
	
	public String getWorkoutStatus() {
		return workoutStatus;
	}
	public void setWorkoutStatus(String workoutStatus) {
		this.workoutStatus = workoutStatus;
	}
	public String getExerciseStatus() {
		return exerciseStatus;
	}
	public void setExerciseStatus(String exerciseStatus) {
		this.exerciseStatus = exerciseStatus;
	}
	public String getCalendar_id() {
		return calendar_id;
	}
	public void setCalendar_id(String calendar_id) {
		this.calendar_id = calendar_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getWorkoutId() {
		return workoutId;
	}
	public void setWorkoutId(String workoutId) {
		this.workoutId = workoutId;
	}
	public String getTrainee_id() {
		return trainee_id;
	}
	public void setTrainee_id(String trainee_id) {
		this.trainee_id = trainee_id;
	}
	public List<Object> getSets() {
		return sets;
	}
	public void setSets(List<Object> sets) {
		this.sets = sets;
	}
	
	public String getWorkoutPercentage() {
		return workoutPercentage;
	}
	public void setWorkoutPercentage(String workoutPercentage) {
		this.workoutPercentage = workoutPercentage;
	}
	public String getExercisePercentage() {
		return exercisePercentage;
	}
	public void setExercisePercentage(String exercisePercentage) {
		this.exercisePercentage = exercisePercentage;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getExercise_referenceId() {
		return exercise_referenceId;
	}
	public void setExercise_referenceId(int exercise_referenceId) {
		this.exercise_referenceId = exercise_referenceId;
	}
	public String getProgram_id() {
		return program_id;
	}
	public void setProgram_id(String program_id) {
		this.program_id = program_id;
	}
	

}
