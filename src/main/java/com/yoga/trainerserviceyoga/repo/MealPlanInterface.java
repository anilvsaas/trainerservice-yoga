package com.yoga.trainerserviceyoga.repo;

import com.yoga.trainerserviceyoga.childmodel.calendar.MealPlanDay;
import com.yoga.trainerserviceyoga.model.CalendarUpdatetModel;
import com.yoga.trainerserviceyoga.model.MasterMealplanModel;
import com.yoga.trainerserviceyoga.model.MealplanModel;
import com.yoga.trainerserviceyoga.model.SelfMealPlan;
import com.yoga.trainerserviceyoga.model.SubscriptionModel;
import com.yoga.trainerserviceyoga.model.TraineeCalendarModel;
import com.yoga.trainerserviceyoga.model.TraineeModel;

public interface MealPlanInterface {
	MealPlanDay getDayMeal(String trainee_id, String program_id, String date);

	void updateDayMealPlan(CalendarUpdatetModel daymeal);

	void updateMealPlanCalendar(CalendarUpdatetModel data);

	void updateMealPlan(MealplanModel mealplan);

	MealplanModel getTraineeMealPlan(String trainee_id, String program_id);

	void updateTraineeCalendar(TraineeCalendarModel traineecalendar);

	TraineeCalendarModel getTraineeCalendar(String trainee_id, String program_id);

	void updateTrainee(TraineeModel trainee);

	MasterMealplanModel getMasterMealPlan(String trainee_id, String program_id);

	void updateMasterMealPlan(MasterMealplanModel mealplan);

	void updateSubscription(SubscriptionModel subscriptionModel);

	SelfMealPlan getSelfMeal(String trainee_id, String date);
}
