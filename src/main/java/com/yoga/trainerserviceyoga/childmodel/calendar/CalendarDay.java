package com.yoga.trainerserviceyoga.childmodel.calendar;
import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yoga.trainerserviceyoga.model.AsanaModel;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CalendarDay {
	private int day;
	private Cardio cardio;
	private boolean rest;
	private boolean progress_photo;
	private String date;
	private String dayStatus;
	private String dayPercentage;
	private MealPlan mealplan;
	private Object[] schedular;
	private String calendar_id;
	private String program_id;
	private String trainee_id;
	private List<AsanaModel> asanas;
	
	public List<AsanaModel> getAsanas() {
		return asanas;
	}

	public void setAsanas(List<AsanaModel> asanas) {
		this.asanas = asanas;
	}

	public String getCalendar_id() {
		return calendar_id;
	}

	public void setCalendar_id(String calendar_id) {
		this.calendar_id = calendar_id;
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

	public MealPlan getMealplan() {
		return mealplan;
	}

	public void setMealplan(MealPlan mealplan) {
		this.mealplan = mealplan;
	}

	public Object[] getSchedular() {
		return schedular;
	}

	public void setSchedular(Object[] schedular) {
		this.schedular = schedular;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDayStatus() {
		return dayStatus;
	}

	public void setDayStatus(String dayStatus) {
		this.dayStatus = dayStatus;
	}

	public String getDayPercentage() {
		return dayPercentage;
	}

	public void setDayPercentage(String dayPercentage) {
		this.dayPercentage = dayPercentage;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

//	public List<WorkoutCalendarReference> getWorkouts() {
//		return workouts;
//	}
//
//	public void setWorkouts(List<WorkoutCalendarReference> workouts) {
//		this.workouts = workouts;
//	}

	public Cardio getCardio() {
		return cardio;
	}

	public void setCardio(Cardio cardio) {
		this.cardio = cardio;
	}

	public boolean isRest() {
		return rest;
	}

	public void setRest(boolean rest) {
		this.rest = rest;
	}

	public boolean isProgress_photo() {
		return progress_photo;
	}

	public void setProgress_photo(boolean progress_photo) {
		this.progress_photo = progress_photo;
	}

}
