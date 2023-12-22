package com.yoga.trainerserviceyoga.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yoga.trainerserviceyoga.childmodel.calendar.CalendarWeek;
import com.yoga.trainerserviceyoga.childmodel.calendar.Macros;
import com.yoga.trainerserviceyoga.childmodel.calendar.Meal;
import com.yoga.trainerserviceyoga.childmodel.calendar.MealPlan;
import com.yoga.trainerserviceyoga.childmodel.calendar.MealPlanDay;
import com.yoga.trainerserviceyoga.childmodel.calendar.MealplanWeek;
import com.yoga.trainerserviceyoga.childmodel.calendar.NutriValue;
import com.yoga.trainerserviceyoga.model.CalendarUpdatetModel;
import com.yoga.trainerserviceyoga.model.MasterMealplanModel;
import com.yoga.trainerserviceyoga.model.MealplanModel;
import com.yoga.trainerserviceyoga.model.NutritionMealModel;
import com.yoga.trainerserviceyoga.model.PublishDataModel;
import com.yoga.trainerserviceyoga.model.SelfMealPlan;
import com.yoga.trainerserviceyoga.model.SubscriptionModel;
import com.yoga.trainerserviceyoga.model.TraineeCalendarModel;
import com.yoga.trainerserviceyoga.model.TraineeModel;
import com.yoga.trainerserviceyoga.repo.MealPlanInterface;

import io.swagger.annotations.Api;

//@XRayEnabled
@RestController
@RequestMapping(value = "/api/trainer/yoga/mealplan")
@Api(value = "fitness", description = "CRUD operations on mealplan")
@CrossOrigin("*")
public class MealPlanController {

	private final MealPlanInterface mealPlan;

	public MealPlanController(MealPlanInterface mealPlan) {
		this.mealPlan = mealPlan;
	}

	// Get daily meal plan
	@RequestMapping(value = "/day", method = RequestMethod.GET)
	public ResponseEntity<Object> getDayFromMealPlan(@RequestParam String trainee_id, @RequestParam String program_id,
			@RequestParam String date) {
		MealPlanDay result = mealPlan.getDayMeal(trainee_id, program_id, date);
		if (result != null) {
			return ResponseHandler.generateResponse(HttpStatus.OK, "Meal plan day data retrieved successfully.",
					result);
		} else {
			return ResponseHandler.generateResponse(HttpStatus.OK, "No data found for this date.", result);
		}
	}

	// Update a day meal plan
	@RequestMapping(value = "/day", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateDayMealPlan(@RequestBody CalendarUpdatetModel data) {
		if (data.getMealplan() != null) {
			// this.trainee.updateTraineeCalendar(data);
			this.mealPlan.updateDayMealPlan(data);
		} else {
			this.mealPlan.updateMealPlanCalendar(data);
		}
		return ResponseHandler.generateResponse(HttpStatus.OK, "Meal plan updated successfully.", "");
	}

	// Update a meal plan
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateMealPlan(@RequestBody MealplanModel mealplanModel) {
		this.mealPlan.updateMealPlan(mealplanModel);
		MasterMealplanModel mealplan = mealPlan.getMasterMealPlan(mealplanModel.getTrainee_id(),
				mealplanModel.getProgram_id());
		List<MealplanWeek> mealplan_weeks = mealplanModel.getWeeks();
		List<MealplanWeek> master_mealplan_weeks = mealplan.getWeeks();
		for (int i = 0; i < mealplan_weeks.size(); i++) {
			for (int j = 0; j < master_mealplan_weeks.size(); j++) {
				List<MealPlanDay> mealplan_days = mealplan_weeks.get(i).getDays();
				List<MealPlanDay> master_mealplan_days = master_mealplan_weeks.get(j).getDays();
				for (int k = 0; k < mealplan_days.size(); k++) {
					for (int l = 0; l < master_mealplan_days.size(); l++) {
						if (mealplan_days.get(k).getDay() == master_mealplan_days.get(l).getDay()) {
							master_mealplan_days.get(k).setMealplan(mealplan_days.get(l).getMealplan());
							break;
						}
					}
				}
			}
		}
		mealplan.setWeeks(mealplan_weeks);
		this.mealPlan.updateMasterMealPlan(mealplan);
		return ResponseHandler.generateResponse(HttpStatus.OK, "Meal plan updated successfully.", "");
	}

	// Get meal plan
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Object> getMealPlan(@RequestParam String trainee_id, @RequestParam String program_id) {
		MealplanModel result = this.mealPlan.getTraineeMealPlan(trainee_id, program_id);
		return ResponseHandler.generateResponse(HttpStatus.OK, "Meal plan retrieved successfully.", result);
	}

	// Get meal plan
	@RequestMapping(value = "/master", method = RequestMethod.GET)
	public ResponseEntity<Object> getMasterMealPlan(@RequestParam String trainee_id, @RequestParam String program_id) {
		MasterMealplanModel result = this.mealPlan.getMasterMealPlan(trainee_id, program_id);
		return ResponseHandler.generateResponse(HttpStatus.OK, "Meal plan retrieved successfully.", result);
	}

	// Update a meal plan
	@RequestMapping(value = "/trainee", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateTraineeCalendar(@RequestBody TraineeCalendarModel traineecalendar) {
		this.mealPlan.updateTraineeCalendar(traineecalendar);
		return ResponseHandler.generateResponse(HttpStatus.OK, "Calendar updated successfully.", "");
	}

	// Publish trainee meal plan calendar
	@RequestMapping(value = "/calendar/publish", method = RequestMethod.POST)
	public ResponseEntity<Object> publishTraineeMealPlanCalendar(@RequestBody PublishDataModel publishData) {
		
		MealplanModel mealplan_data = this.mealPlan.getTraineeMealPlan(publishData.getTrainee_id(),
				publishData.getProgram_id());
		MasterMealplanModel mastermeal = this.mealPlan.getMasterMealPlan(publishData.getTrainee_id(), publishData.getProgram_id());
		
		List<MealplanWeek> meal_weeks = mealplan_data.getWeeks();
		Date startDate = publishData.getStart_date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.DATE, -1);
		//System.out.println("date before 1 days : " + getDate(cal));
		for (int k = 0; k < meal_weeks.size(); k++) {
			for (int l = 0; l < meal_weeks.get(k).getDays().size(); l++) {
				// add days to start date
				cal.add(Calendar.DATE, meal_weeks.get(k).getDays().get(l).getDay());
			//	System.out.println("week: " + meal_weeks.get(k).getWeek() + ", date: " + getDate(cal));
				meal_weeks.get(k).getDays().get(l).setDate(getDate(cal));

				SelfMealPlan selfmeal = this.mealPlan.getSelfMeal(publishData.getTrainee_id(), getDate(cal));
				if(selfmeal != null) {
					
						if(selfmeal.getMealplan().getBreakfast() != null) {
							List<NutritionMealModel> result =  new ArrayList<NutritionMealModel>();
							result.addAll(selfmeal.getMealplan().getBreakfast().getFoodItems());
							result.addAll(meal_weeks.get(k).getDays().get(l).getMealplan().getBreakfast().getFoodItems());
							meal_weeks.get(k).getDays().get(l).getMealplan().getBreakfast().setFoodItems(result);
							meal_weeks.get(k).getDays().get(l).getMealplan().setBreakfast(this.CalculateRecommendedNutrientsByMeal(meal_weeks.get(k).getDays().get(l).getMealplan().getBreakfast()));
							meal_weeks.get(k).getDays().get(l).getMealplan().setBreakfast(this.CalculateNutrientsByMeal(meal_weeks.get(k).getDays().get(l).getMealplan().getBreakfast()));
						}
						
						if(selfmeal.getMealplan().getLunch() != null) {
							List<NutritionMealModel> result =  new ArrayList<NutritionMealModel>();
							result.addAll(selfmeal.getMealplan().getLunch().getFoodItems());
							result.addAll(meal_weeks.get(k).getDays().get(l).getMealplan().getLunch().getFoodItems());
							meal_weeks.get(k).getDays().get(l).getMealplan().getLunch().setFoodItems(result);
							meal_weeks.get(k).getDays().get(l).getMealplan().setLunch(this.CalculateRecommendedNutrientsByMeal(meal_weeks.get(k).getDays().get(l).getMealplan().getLunch()));
							meal_weeks.get(k).getDays().get(l).getMealplan().setLunch(this.CalculateNutrientsByMeal(meal_weeks.get(k).getDays().get(l).getMealplan().getLunch()));
						}
						
						if(selfmeal.getMealplan().getSnacks() != null) {
							List<NutritionMealModel> result =  new ArrayList<NutritionMealModel>();
							result.addAll(selfmeal.getMealplan().getSnacks().getFoodItems());
							result.addAll(meal_weeks.get(k).getDays().get(l).getMealplan().getSnacks().getFoodItems());
							meal_weeks.get(k).getDays().get(l).getMealplan().getSnacks().setFoodItems(result);
							meal_weeks.get(k).getDays().get(l).getMealplan().setSnacks(this.CalculateRecommendedNutrientsByMeal(meal_weeks.get(k).getDays().get(l).getMealplan().getSnacks()));
							meal_weeks.get(k).getDays().get(l).getMealplan().setSnacks(this.CalculateNutrientsByMeal(meal_weeks.get(k).getDays().get(l).getMealplan().getSnacks()));
						}
						if(selfmeal.getMealplan().getDinner() != null) {
							List<NutritionMealModel> result =  new ArrayList<NutritionMealModel>();
							result.addAll(selfmeal.getMealplan().getDinner().getFoodItems());
							result.addAll(meal_weeks.get(k).getDays().get(l).getMealplan().getDinner().getFoodItems());
							meal_weeks.get(k).getDays().get(l).getMealplan().getDinner().setFoodItems(result);
							meal_weeks.get(k).getDays().get(l).getMealplan().setDinner(this.CalculateRecommendedNutrientsByMeal(meal_weeks.get(k).getDays().get(l).getMealplan().getDinner()));
							meal_weeks.get(k).getDays().get(l).getMealplan().setDinner(this.CalculateNutrientsByMeal(meal_weeks.get(k).getDays().get(l).getMealplan().getDinner()));
						}
						
						
						meal_weeks.get(k).getDays().get(l).setMealplan(this.CalculateRecommendedNutrientsByDay(meal_weeks.get(k).getDays().get(l).getMealplan()));
						meal_weeks.get(k).getDays().get(l).setMealplan(this.CalculateNutrientsByDay(meal_weeks.get(k).getDays().get(l).getMealplan()));
					
				}
				// remove days from start date
				cal.add(Calendar.DATE, -(meal_weeks.get(k).getDays().get(l).getDay()));
				
			}
		}
		cal.setTime(startDate); // Now use today date.
//		cal.add(Calendar.DATE, (meal_weeks.size() * 7)); // Adding days
		cal.add(Calendar.DATE, (meal_weeks.size() * 7) - 1);// Adding days
		mealplan_data.setEndDate(cal.getTime());
		mealplan_data.setWeeks(meal_weeks);
		mealplan_data.setTrainer_status("published");
		mealplan_data.setStartDate(publishData.getStart_date());
		mealplan_data.setIsSlaCrossed(publishData.getIsSlaCrossed());
		mastermeal.setWeeks(meal_weeks);
		this.mealPlan.updateMealPlan(mealplan_data);
		this.mealPlan.updateMasterMealPlan(mastermeal);
//		TraineeModel trainee = new TraineeModel();
//		trainee.setProgram_startdate(new Date());
//        trainee.setTrainee_id(publishData.getTrainee_id());
//        this.mealPlan.updateTrainee(trainee);

        
		return ResponseHandler.generateResponse(HttpStatus.OK, "Calendar published successfully.", "");
	}

	// Publish trainee calendar
	@RequestMapping(value = "/calendar/asana/publish", method = RequestMethod.POST)
	public ResponseEntity<Object> publishTraineeCalendar(@RequestBody PublishDataModel publishData) {
		TraineeCalendarModel traineecalendar = mealPlan.getTraineeCalendar(publishData.getTrainee_id(),
				publishData.getProgram_id());

		List<CalendarWeek> weeks_data = traineecalendar.getWeeks();
		Date startDate = publishData.getStart_date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.DATE, -1);
		// System.out.println("date before 1 days : " + getDate(cal));
		for (int k = 0; k < weeks_data.size(); k++) {
			for (int l = 0; l < weeks_data.get(k).getDays().size(); l++) {
				// add days to start date
				cal.add(Calendar.DATE, weeks_data.get(k).getDays().get(l).getDay());
				// System.out.println("week: " + weeks_data.get(k).getWeek() + ", date: " +
				// getDate(cal));
				weeks_data.get(k).getDays().get(l).setDate(getDate(cal));
				// remove days from start date
				cal.add(Calendar.DATE, -(weeks_data.get(k).getDays().get(l).getDay()));
			}
		}
		// Calendar c = Calendar.getInstance();
		cal.setTime(startDate); // Now use today date.
		cal.add(Calendar.DATE, (weeks_data.size() * 7) - 1); // Adding days
		traineecalendar.setEndDate(cal.getTime());
		traineecalendar.setWeeks(weeks_data);
		traineecalendar.setTrainer_status(publishData.getTrainer_status());
		traineecalendar.setStartDate(publishData.getStart_date());
		traineecalendar.setIsSlaCrossed(publishData.getIsSlaCrossed());
		this.mealPlan.updateTraineeCalendar(traineecalendar);
		TraineeModel trainee = new TraineeModel();
		trainee.setProgram_startdate(publishData.getStart_date());
		trainee.setTrainee_id(publishData.getTrainee_id());
		this.mealPlan.updateTrainee(trainee);

		SubscriptionModel subscriptionModel = new SubscriptionModel();
		subscriptionModel.setTrainee_id(publishData.getTrainee_id());
		subscriptionModel.setProgram_id(publishData.getProgram_id());
		subscriptionModel.setProgram_start_date(publishData.getStart_date());
		subscriptionModel.setProgram_end_date(cal.getTime());
		subscriptionModel.setIsProgramPublished(true);
		subscriptionModel.setIsSlaCrossed(publishData.getIsSlaCrossed());
		this.mealPlan.updateSubscription(subscriptionModel);

		return ResponseHandler.generateResponse(HttpStatus.OK, "Calendar published successfully.", "");
	}

	// Get date
	public static String getDate(Calendar cal) {
		if (cal.get(Calendar.DATE) < 10 || cal.get(Calendar.MONTH) < 10) {
			String d = "";
			String m = "";
			if (cal.get(Calendar.DATE) < 10) {
				d = "0" + cal.get(Calendar.DATE);
			} else {
				d = "" + cal.get(Calendar.DATE);
			}
			if ((cal.get(Calendar.MONTH) + 1) < 10) {
				m = "0" + (cal.get(Calendar.MONTH) + 1);
			} else {
				m = "" + (cal.get(Calendar.MONTH) + 1);
			}
			return "" + d + "/" + m + "/" + cal.get(Calendar.YEAR);
		} else {
			return "" + cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
		}
	}

	public Meal CalculateRecommendedNutrientsByMeal(Meal meal) {

		List<NutritionMealModel> nutrition_list = meal.getFoodItems();
		meal.setOverall_protein_recommended(0);
		meal.setOverall_carboHydrate_recommended(0);
		meal.setOverall_fibre_recommended(0);
		meal.setOverall_fat_recommended(0);
		meal.setOverall_calories_recommended(0);
		if (nutrition_list != null) {
			for (NutritionMealModel nutrition : nutrition_list) {
				NutriValue protien = nutrition.getNf_protein();
				NutriValue carboHydrate = nutrition.getNf_total_carbohydrate();
				NutriValue fibre = nutrition.getNf_dietary_fiber();
				NutriValue fat = nutrition.getNf_total_fat();
				NutriValue energy = nutrition.getNf_calories();

				double overall_protein = Math
						.round((meal.getOverall_protein_recommended() + protien.getRecommended()) * 100);
				meal.setOverall_protein_recommended(overall_protein / 100);

				double overall_carbs = Math
						.round((meal.getOverall_carboHydrate_recommended() + carboHydrate.getRecommended()) * 100);
				meal.setOverall_carboHydrate_recommended(overall_carbs / 100);

				double overall_fibre = Math.round((meal.getOverall_fibre_recommended() + fibre.getRecommended()) * 100);
				meal.setOverall_fibre_recommended(overall_fibre / 100);

				double overall_fat = Math.round((meal.getOverall_fat_recommended() + fat.getRecommended()) * 100);
				meal.setOverall_fat_recommended(overall_fat / 100);

				double overall_calories = Math
						.round((meal.getOverall_calories_recommended() + energy.getRecommended()) * 100);
				meal.setOverall_calories_recommended(overall_calories / 100.0);
			}
		}
		if (meal.getMacros() != null) {
			Macros macros = meal.getMacros();
			double totalMacros = (meal.getOverall_carboHydrate_recommended() * 4)
					+ (meal.getOverall_fat_recommended() * 9) + (meal.getOverall_protein_recommended() * 4);

			macros.setCarboHydrate_recommended(
					this.CalculateMacros(totalMacros, meal.getOverall_carboHydrate_recommended(), "carboHydrate"));
			macros.setFat_recommended(this.CalculateMacros(totalMacros, meal.getOverall_fat_recommended(), "fat"));
			macros.setProtein_recommended(
					this.CalculateMacros(totalMacros, meal.getOverall_protein_recommended(), "protein"));
			meal.setMacros(macros);
		} else {
			Macros macros = new Macros();

			double totalMacros = (meal.getOverall_carboHydrate_recommended() * 4)
					+ (meal.getOverall_fat_recommended() * 9) + (meal.getOverall_protein_recommended() * 4);

			macros.setCarboHydrate_recommended(
					this.CalculateMacros(totalMacros, meal.getOverall_carboHydrate_recommended(), "carboHydrate"));
			macros.setFat_recommended(this.CalculateMacros(totalMacros, meal.getOverall_fat_recommended(), "fat"));
			macros.setProtein_recommended(
					this.CalculateMacros(totalMacros, meal.getOverall_protein_recommended(), "protein"));
			meal.setMacros(macros);
		}

		return meal;
	}
	
	public int CalculateMacros(double calories, double nutrient_value, String type) {
		if (type.equals("fat")) {
			double covertedKcal = nutrient_value * 9;
			return (int) Math.round((covertedKcal / calories) * 100);
		} else {
			double covertedKcal = nutrient_value * 4;
			return (int) Math.round((covertedKcal / calories) * 100);
		}
	}
	
	public MealPlan CalculateRecommendedNutrientsByDay(MealPlan meal) {
		Meal breakfast = meal.getBreakfast();
		Meal lunch = meal.getLunch();
		Meal dinner = meal.getDinner();
		Meal snacks = meal.getSnacks();

		meal.setOverall_protein_recommended(0);
		meal.setOverall_carboHydrate_recommended(0);
		meal.setOverall_fibre_recommended(0);
		meal.setOverall_fat_recommended(0);
		meal.setOverall_calories_recommended(0);

		double totalProteinRecommended = 0;
		double totalFatRecommended = 0;
		double totalCarbsRecommended = 0;
		double totalFibreRecommended = 0;
		double totalEnergyRecommended = 0;
		// double totalCalciumRecommended = 0;
		if (breakfast != null) {
			totalProteinRecommended = totalProteinRecommended + breakfast.getOverall_protein_recommended();
			totalFatRecommended = totalFatRecommended + breakfast.getOverall_fat_recommended();
			totalCarbsRecommended = totalCarbsRecommended + breakfast.getOverall_carboHydrate_recommended();
			totalFibreRecommended = totalFibreRecommended + breakfast.getOverall_fibre_recommended();
			totalEnergyRecommended = totalEnergyRecommended + breakfast.getOverall_calories_recommended();
		}
		if (lunch != null) {
			totalProteinRecommended = totalProteinRecommended + lunch.getOverall_protein_recommended();
			totalFatRecommended = totalFatRecommended + lunch.getOverall_fat_recommended();
			totalCarbsRecommended = totalCarbsRecommended + lunch.getOverall_carboHydrate_recommended();
			totalFibreRecommended = totalFibreRecommended + lunch.getOverall_fibre_recommended();
			totalEnergyRecommended = totalEnergyRecommended + lunch.getOverall_calories_recommended();
		}
		if (dinner != null) {
			totalProteinRecommended = totalProteinRecommended + dinner.getOverall_protein_recommended();
			totalFatRecommended = totalFatRecommended + dinner.getOverall_fat_recommended();
			totalCarbsRecommended = totalCarbsRecommended + dinner.getOverall_carboHydrate_recommended();
			totalFibreRecommended = totalFibreRecommended + dinner.getOverall_fibre_recommended();
			totalEnergyRecommended = totalEnergyRecommended + dinner.getOverall_calories_recommended();

		}
		if (snacks != null) {
			totalProteinRecommended = totalProteinRecommended + snacks.getOverall_protein_recommended();
			totalFatRecommended = totalFatRecommended + snacks.getOverall_fat_recommended();
			totalCarbsRecommended = totalCarbsRecommended + snacks.getOverall_carboHydrate_recommended();
			totalFibreRecommended = totalFibreRecommended + snacks.getOverall_fibre_recommended();
			totalEnergyRecommended = totalEnergyRecommended + snacks.getOverall_calories_recommended();
		}

		double overall_protein = Math.round(totalProteinRecommended * 100);
		meal.setOverall_protein_recommended(overall_protein / 100);

		double overall_fat = Math.round(totalFatRecommended * 100);
		meal.setOverall_fat_recommended(overall_fat / 100);

		double overall_carbs = Math.round(totalCarbsRecommended * 100);
		meal.setOverall_carboHydrate_recommended(overall_carbs / 100);

		double overall_fibre = Math.round(totalFibreRecommended * 100);
		meal.setOverall_fibre_recommended(overall_fibre / 100);

		double overall_calories = Math.round(totalEnergyRecommended * 100);
		meal.setOverall_calories_recommended(overall_calories / 100);

		if (meal.getMacros() != null) {
			Macros macros = meal.getMacros();
			double totalMacros = (meal.getOverall_carboHydrate_recommended() * 4)
					+ (meal.getOverall_fat_recommended() * 9) + (meal.getOverall_protein_recommended() * 4);

			macros.setCarboHydrate_recommended(
					this.CalculateMacros(totalMacros, meal.getOverall_carboHydrate_recommended(), "carboHydrate"));
			macros.setFat_recommended(this.CalculateMacros(totalMacros, meal.getOverall_fat_recommended(), "fat"));
			macros.setProtein_recommended(
					this.CalculateMacros(totalMacros, meal.getOverall_protein_recommended(), "protein"));
			meal.setMacros(macros);
		} else {
			Macros macros = new Macros();
			double totalMacros = (meal.getOverall_carboHydrate_recommended() * 4)
					+ (meal.getOverall_fat_recommended() * 9) + (meal.getOverall_protein_recommended() * 4);

			macros.setCarboHydrate_recommended(
					this.CalculateMacros(totalMacros, meal.getOverall_carboHydrate_recommended(), "carboHydrate"));
			macros.setFat_recommended(this.CalculateMacros(totalMacros, meal.getOverall_fat_recommended(), "fat"));
			macros.setProtein_recommended(
					this.CalculateMacros(totalMacros, meal.getOverall_protein_recommended(), "protein"));
			meal.setMacros(macros);
		}

		return meal;
	}
	
	public Meal CalculateNutrientsByMeal(Meal meal) {
		if (meal != null) {
			List<NutritionMealModel> nutrition_list = meal.getFoodItems();
			meal.setOverall_protein_consumed(0);
			meal.setOverall_carboHydrate_consumed(0);
			meal.setOverall_fibre_consumed(0);
			meal.setOverall_fat_consumed(0);
			meal.setOverall_calories_consumed(0);
			if (nutrition_list != null) {
				for (NutritionMealModel nutrition : nutrition_list) {
					NutriValue protien = nutrition.getNf_protein();
					NutriValue carboHydrate = nutrition.getNf_total_carbohydrate();
					NutriValue fibre = nutrition.getNf_dietary_fiber();
					NutriValue fat = nutrition.getNf_total_fat();
					NutriValue energy = nutrition.getNf_calories();

					double overall_protein = Math
							.round((meal.getOverall_protein_consumed() + protien.getConsumed()) * 100);
					meal.setOverall_protein_consumed(overall_protein / 100);

					double overall_carbs = Math
							.round((meal.getOverall_carboHydrate_consumed() + carboHydrate.getConsumed()) * 100);
					meal.setOverall_carboHydrate_consumed(overall_carbs / 100);

					double overall_fibre = Math.round((meal.getOverall_fibre_consumed() + fibre.getConsumed()) * 100);
					meal.setOverall_fibre_consumed(overall_fibre / 100);

					double overall_fat = Math.round((meal.getOverall_fat_consumed() + fat.getConsumed()) * 100);
					meal.setOverall_fat_consumed(overall_fat / 100);

					double overall_calories = Math
							.round((meal.getOverall_calories_consumed() + energy.getConsumed()) * 100);
					meal.setOverall_calories_consumed(overall_calories / 100);

				}
				if (meal.getMacros() != null) {
					Macros macros = meal.getMacros();
					double totalMacros = (meal.getOverall_carboHydrate_consumed() * 4)
							+ (meal.getOverall_fat_consumed() * 9) + (meal.getOverall_protein_consumed() * 4);

					macros.setCarboHydrate_consumed(
							this.CalculateMacros(totalMacros, meal.getOverall_carboHydrate_consumed(), "carboHydrate"));
					macros.setFat_consumed(this.CalculateMacros(totalMacros, meal.getOverall_fat_consumed(), "fat"));
					macros.setProtein_consumed(
							this.CalculateMacros(totalMacros, meal.getOverall_protein_consumed(), "protein"));
					meal.setMacros(macros);
				} else {
					Macros macros = new Macros();
					double totalMacros = (meal.getOverall_carboHydrate_consumed() * 4)
							+ (meal.getOverall_fat_consumed() * 9) + (meal.getOverall_protein_consumed() * 4);

					macros.setCarboHydrate_consumed(
							this.CalculateMacros(totalMacros, meal.getOverall_carboHydrate_consumed(), "carboHydrate"));
					macros.setFat_consumed(this.CalculateMacros(totalMacros, meal.getOverall_fat_consumed(), "fat"));
					macros.setProtein_consumed(
							this.CalculateMacros(totalMacros, meal.getOverall_protein_consumed(), "protein"));
					meal.setMacros(macros);
				}
			}
		}
		return meal;

	}
	
	public MealPlan CalculateNutrientsByDay(MealPlan meal) {
		Meal breakfast = meal.getBreakfast();
		Meal lunch = meal.getLunch();
		Meal dinner = meal.getDinner();
		Meal snacks = meal.getSnacks();

		meal.setOverall_protein_consumed(0);
		meal.setOverall_carboHydrate_consumed(0);
		meal.setOverall_fibre_consumed(0);
		meal.setOverall_fat_consumed(0);
		meal.setOverall_calories_consumed(0);

		double totalProteinConsumed = 0;
		double totalFatConsumed = 0;
		double totalCarbsConsumed = 0;
		double totalFibreConsumed = 0;
		double totalEnergyConsumed = 0;
		double totalCalciumConsumed = 0;
		if (breakfast != null) {
			totalProteinConsumed = totalProteinConsumed + breakfast.getOverall_protein_consumed();
			totalFatConsumed = totalFatConsumed + breakfast.getOverall_fat_consumed();
			totalCarbsConsumed = totalCarbsConsumed + breakfast.getOverall_carboHydrate_consumed();
			totalFibreConsumed = totalFibreConsumed + breakfast.getOverall_fibre_consumed();
			totalEnergyConsumed = totalEnergyConsumed + breakfast.getOverall_calories_consumed();
		}
		if (lunch != null) {
			totalProteinConsumed = totalProteinConsumed + lunch.getOverall_protein_consumed();
			totalFatConsumed = totalFatConsumed + lunch.getOverall_fat_consumed();
			totalCarbsConsumed = totalCarbsConsumed + lunch.getOverall_carboHydrate_consumed();
			totalFibreConsumed = totalFibreConsumed + lunch.getOverall_fibre_consumed();
			totalEnergyConsumed = totalEnergyConsumed + lunch.getOverall_calories_consumed();
		}
		if (dinner != null) {
			totalProteinConsumed = totalProteinConsumed + dinner.getOverall_protein_consumed();
			totalFatConsumed = totalFatConsumed + dinner.getOverall_fat_consumed();
			totalCarbsConsumed = totalCarbsConsumed + dinner.getOverall_carboHydrate_consumed();
			totalFibreConsumed = totalFibreConsumed + dinner.getOverall_fibre_consumed();
			totalEnergyConsumed = totalEnergyConsumed + dinner.getOverall_calories_consumed();

		}
		if (snacks != null) {
			totalProteinConsumed = totalProteinConsumed + snacks.getOverall_protein_consumed();
			totalFatConsumed = totalFatConsumed + snacks.getOverall_fat_consumed();
			totalCarbsConsumed = totalCarbsConsumed + snacks.getOverall_carboHydrate_consumed();
			totalFibreConsumed = totalFibreConsumed + snacks.getOverall_fibre_consumed();
			totalEnergyConsumed = totalEnergyConsumed + snacks.getOverall_calories_consumed();
		}
		double overall_protein = Math.round(totalProteinConsumed * 100);
		meal.setOverall_protein_consumed(overall_protein / 100);

		double overall_fat = Math.round(totalFatConsumed * 100);
		meal.setOverall_fat_consumed(overall_fat / 100);

		double overall_carbs = Math.round(totalCarbsConsumed * 100);
		meal.setOverall_carboHydrate_consumed(overall_carbs / 100);

		double overall_fibre = Math.round(totalFibreConsumed * 100);
		meal.setOverall_fibre_consumed(overall_fibre / 100);

		double overall_calories = Math.round(totalEnergyConsumed * 100);
		meal.setOverall_calories_consumed(overall_calories / 100);

		if (meal.getMacros() != null) {
			Macros macros = meal.getMacros();
			double totalMacros = (meal.getOverall_carboHydrate_consumed() * 4) + (meal.getOverall_fat_consumed() * 9)
					+ (meal.getOverall_protein_consumed() * 4);
			macros.setCarboHydrate_consumed(
					this.CalculateMacros(totalMacros, meal.getOverall_carboHydrate_consumed(), "carboHydrate"));
			macros.setFat_consumed(this.CalculateMacros(totalMacros, meal.getOverall_fat_consumed(), "fat"));
			macros.setProtein_consumed(
					this.CalculateMacros(totalMacros, meal.getOverall_protein_consumed(), "protein"));
			meal.setMacros(macros);
		} else {
			Macros macros = new Macros();

			double totalMacros = (meal.getOverall_carboHydrate_consumed() * 4) + (meal.getOverall_fat_consumed() * 9)
					+ (meal.getOverall_protein_consumed() * 4);

			macros.setCarboHydrate_consumed(
					this.CalculateMacros(totalMacros, meal.getOverall_carboHydrate_consumed(), "carboHydrate"));
			macros.setFat_consumed(this.CalculateMacros(totalMacros, meal.getOverall_fat_consumed(), "fat"));
			macros.setProtein_consumed(
					this.CalculateMacros(totalMacros, meal.getOverall_protein_consumed(), "protein"));
			meal.setMacros(macros);
		}

		return meal;
	}
}
