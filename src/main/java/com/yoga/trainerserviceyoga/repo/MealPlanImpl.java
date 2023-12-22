package com.yoga.trainerserviceyoga.repo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.UpdateResult;
import com.yoga.trainerserviceyoga.childmodel.calendar.Meal;
import com.yoga.trainerserviceyoga.childmodel.calendar.MealPlan;
import com.yoga.trainerserviceyoga.childmodel.calendar.MealPlanDay;
import com.yoga.trainerserviceyoga.childmodel.calendar.MealplanWeek;
import com.yoga.trainerserviceyoga.childmodel.calendar.NutriValue;
import com.yoga.trainerserviceyoga.model.CalendarUpdatetModel;
import com.yoga.trainerserviceyoga.model.MasterMealplanModel;
import com.yoga.trainerserviceyoga.model.MealplanModel;
import com.yoga.trainerserviceyoga.model.NutritionMealModel;
import com.yoga.trainerserviceyoga.model.SelfMealPlan;
import com.yoga.trainerserviceyoga.model.SubscriptionModel;
import com.yoga.trainerserviceyoga.model.TraineeCalendarModel;
import com.yoga.trainerserviceyoga.model.TraineeModel;

@Repository
public class MealPlanImpl implements MealPlanInterface {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public MealPlanDay getDayMeal(String trainee_id, String program_id, String date) {
		Query query = new Query();
		query.addCriteria(Criteria.where("program_id").is(program_id));

		query.addCriteria(
				Criteria.where("trainee_id").is(trainee_id).andOperator(Criteria.where("weeks.days.date").is(date)));

		query.fields().include("weeks.days.day");
		query.fields().include("weeks.days.date");
		query.fields().include("weeks.days.mealplan");
		query.fields().include("trainer_status");
		MealplanModel calendar = mongoTemplate.findOne(query, MealplanModel.class);
		MealPlanDay mealPlanDay = new MealPlanDay();
		if (calendar != null) {
			List<MealplanWeek> weeklist = calendar.getWeeks();
			for (MealplanWeek weekObject : weeklist) {
				List<MealPlanDay> dayList = weekObject.getDays();
				for (MealPlanDay mealDay : dayList) {
					if (mealDay.getDate().equals(date)) {
						mealPlanDay = mealDay;
						mealPlanDay.setProgram_id(program_id);
						mealPlanDay.setTrainee_id(trainee_id);
					}
				}
			}
			return mealPlanDay;
		} else {
			return null;
		}

	}
	
	@Override
	public void updateDayMealPlan(CalendarUpdatetModel daymeal) {
		UpdateResult mealplanupdate = mongoTemplate.getDb().getCollection("trainee_yoga_mealplans").updateOne(
				new Document("program_id", daymeal.getProgram_id()).append("trainee_id", daymeal.getTrainee_id()),
				new Document("$set", new Document("weeks.$[].days.$[b].mealplan", daymeal.getMealplan())),
				new UpdateOptions().arrayFilters(Arrays.asList(Filters.eq("b.date", daymeal.getDate()))));
		// System.out.println("Mealplan update: " + mealplanupdate);

		boolean status = this.checkPublishStatus(daymeal.getTrainee_id(), daymeal.getProgram_id());
		
		if(status != true) {
		UpdateResult mealplanupdate_calendr = mongoTemplate.getDb().getCollection("yoga_master_trainee_mealplans").updateOne(
				new Document("program_id", daymeal.getProgram_id()).append("trainee_id", daymeal.getTrainee_id()),
				new Document("$set", new Document("weeks.$[].days.$[b].mealplan", daymeal.getMealplan())),
				new UpdateOptions().arrayFilters(Arrays.asList(Filters.eq("b.date", daymeal.getDate()))));
		}
		// System.out.println("Mealplan update: " + mealplanupdate_calendr);
	}
	@Override
	public void updateMealPlanCalendar(CalendarUpdatetModel data) {

		if (data.getWaterConsumed() != null) {

			UpdateResult waterconsumed = mongoTemplate.getDb().getCollection("yoga_master_trainee_mealplans").updateOne(
					new Document("program_id", data.getProgram_id()).append("trainee_id", data.getTrainee_id()),
					new Document("$set",
							new Document("weeks.$[].days.$[b].mealplan.waterConsumed", data.getWaterConsumed())),
					new UpdateOptions().arrayFilters(Arrays.asList(Filters.eq("b.date", data.getDate()))));
		//	System.out.println("Water consumed update:   " + waterconsumed);

			UpdateResult waterconsumed_mealplan = mongoTemplate.getDb().getCollection("trainee_yoga_mealplans").updateOne(
					new Document("program_id", data.getProgram_id()).append("trainee_id", data.getTrainee_id()),
					new Document("$set",
							new Document("weeks.$[].days.$[b].mealplan.waterConsumed", data.getWaterConsumed())),
					new UpdateOptions().arrayFilters(Arrays.asList(Filters.eq("b.date", data.getDate()))));
		//	System.out.println("Water consumed update:   " + waterconsumed_mealplan);
		}

		if (data.getMealPlanStatus() != null) {

			UpdateResult mealStatusupdate = mongoTemplate.getDb().getCollection("yoga_master_trainee_mealplans").updateOne(
					new Document("program_id", data.getProgram_id()).append("trainee_id", data.getTrainee_id()),
					new Document("$set",
							new Document("weeks.$[].days.$[b].mealplan.mealPlanStatus", data.getMealPlanStatus())),
					new UpdateOptions().arrayFilters(Arrays.asList(Filters.eq("b.date", data.getDate()))));
		//	System.out.println("Meal status update:   " + mealStatusupdate);

			UpdateResult mealStatusupdate_mealplan = mongoTemplate.getDb().getCollection("trainee_yoga_mealplans").updateOne(
					new Document("program_id", data.getProgram_id()).append("trainee_id", data.getTrainee_id()),
					new Document("$set",
							new Document("weeks.$[].days.$[b].mealplan.mealPlanStatus", data.getMealPlanStatus())),
					new UpdateOptions().arrayFilters(Arrays.asList(Filters.eq("b.date", data.getDate()))));
		//	System.out.println("Meal status update:   " + mealStatusupdate_mealplan);
		}

		if (data.getFoodStatus() != null) {

			UpdateResult foodStatusUpdate = mongoTemplate.getDb().getCollection("yoga_master_trainee_mealplans")
					.updateOne(
							new Document("program_id", data.getProgram_id()).append("trainee_id", data.getTrainee_id()),
							new Document("$set",
									new Document("weeks.$[].days.$[b].mealplan." + data.getMealType()
											+ ".foodItems.$[c].foodStatus", data.getFoodStatus())),
							new UpdateOptions().arrayFilters(Arrays.asList(Filters.eq("b.date", data.getDate()),
									Filters.eq("c.foodCode", data.getFoodCode()))));
		//	System.out.println("Food status update:   " + foodStatusUpdate);

			UpdateResult foodStatusUpdate_mealplan = mongoTemplate.getDb().getCollection("trainee_yoga_mealplans")
					.updateOne(
							new Document("program_id", data.getProgram_id()).append("trainee_id", data.getTrainee_id()),
							new Document("$set",
									new Document("weeks.$[].days.$[b].mealplan." + data.getMealType()
											+ ".foodItems.$[c].foodStatus", data.getFoodStatus())),
							new UpdateOptions().arrayFilters(Arrays.asList(Filters.eq("b.date", data.getDate()),
									Filters.eq("c.foodCode", data.getFoodCode()))));
		//	System.out.println("Food status update:   " + foodStatusUpdate_mealplan);

		}

		if (data.getFoodItems() != null) {
			UpdateResult foodStatusUpdate = mongoTemplate.getDb().getCollection("yoga_master_trainee_mealplans").updateOne(
					new Document("program_id", data.getProgram_id()).append("trainee_id", data.getTrainee_id()),
					new Document("$set",
							new Document("weeks.$[].days.$[b].mealplan." + data.getMealType() + ".foodItems",
									data.getFoodItems())),
					new UpdateOptions().arrayFilters(Arrays.asList(Filters.eq("b.date", data.getDate()))));
		//	System.out.println("Food status update:   " + foodStatusUpdate);

			UpdateResult foodStatusUpdate_mealplan = mongoTemplate.getDb().getCollection("trainee_yoga_mealplans").updateOne(
					new Document("program_id", data.getProgram_id()).append("trainee_id", data.getTrainee_id()),
					new Document("$set",
							new Document("weeks.$[].days.$[b].mealplan." + data.getMealType() + ".foodItems",
									data.getFoodItems())),
					new UpdateOptions().arrayFilters(Arrays.asList(Filters.eq("b.date", data.getDate()))));
		//	System.out.println("Food status update:   " + foodStatusUpdate_mealplan);
			
			MealPlanDay result = this.getDayMeal(data.getTrainee_id(), data.getProgram_id(), data.getDate());
			
			MealPlan dayObj = this.getCalculatedDayData(result);
			
			Gson gson= new Gson();
			String tmp = gson.toJson(dayObj);
			Object myObject = gson.fromJson(tmp,Object.class);
			data.setMealplan(myObject);
     		this.updateDayMealPlan(data);
		}
	}

	public Meal CalculateNutrientsByMeal(Meal meal) {

		List<NutritionMealModel> nutrition_list = meal.getFoodItems();
		meal.setOverall_protein_consumed(0);
		meal.setOverall_carboHydrate_consumed(0);
		meal.setOverall_fibre_consumed(0);
		meal.setOverall_fat_consumed(0);
		meal.setOverall_calories_consumed(0);
		
		for (NutritionMealModel nutrition : nutrition_list) {
			NutriValue protien = nutrition.getNf_protein();
			NutriValue carboHydrate = nutrition.getNf_total_carbohydrate();
			NutriValue fibre = nutrition.getNf_dietary_fiber();
			NutriValue fat = nutrition.getNf_total_fat();
			NutriValue calories = nutrition.getNf_calories();
			meal.setOverall_protein_consumed(meal.getOverall_protein_consumed() + protien.getConsumed());
			meal.setOverall_carboHydrate_consumed(meal.getOverall_carboHydrate_consumed() + carboHydrate.getConsumed());
			meal.setOverall_fibre_consumed(meal.getOverall_fibre_consumed() + fibre.getConsumed());
			meal.setOverall_fat_consumed(meal.getOverall_fat_consumed() + fat.getConsumed());
			meal.setOverall_calories_consumed(meal.getOverall_calories_consumed() + calories.getConsumed());
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
		
		meal.setOverall_protein_consumed(breakfast.getOverall_protein_consumed() + lunch.getOverall_protein_consumed()
				+ dinner.getOverall_protein_consumed() + snacks.getOverall_protein_consumed());
		meal.setOverall_carboHydrate_consumed(breakfast.getOverall_carboHydrate_consumed()
				+ lunch.getOverall_carboHydrate_consumed() + dinner.getOverall_carboHydrate_consumed()
				+ snacks.getOverall_carboHydrate_consumed() );
		meal.setOverall_fibre_consumed(breakfast.getOverall_fibre_consumed() + lunch.getOverall_fibre_consumed()
				+ dinner.getOverall_fibre_consumed() + snacks.getOverall_fibre_consumed());
		meal.setOverall_fat_consumed(
				breakfast.getOverall_fat_consumed() + lunch.getOverall_fat_consumed() + dinner.getOverall_fat_consumed()
						+ snacks.getOverall_fat_consumed() );
		meal.setOverall_calories_consumed(breakfast.getOverall_calories_consumed() + lunch.getOverall_calories_consumed()
				+ dinner.getOverall_calories_consumed() + snacks.getOverall_calories_consumed());
		return meal;
	}
	
	public MealPlan getCalculatedDayData(MealPlanDay daymeal) {
		MealPlan mealplan = daymeal.getMealplan();
		mealplan.setBreakfast(this.CalculateNutrientsByMeal(mealplan.getBreakfast()));
		mealplan.setLunch(this.CalculateNutrientsByMeal(mealplan.getLunch()));
		mealplan.setDinner(this.CalculateNutrientsByMeal(mealplan.getDinner()));
		mealplan.setSnacks(this.CalculateNutrientsByMeal(mealplan.getSnacks()));
		MealPlan newMealplan = this.CalculateNutrientsByDay(mealplan);
		return newMealplan;
	}
	
	@Override
	public void updateMealPlan(MealplanModel mealplan) {
		Query query = new Query();
		query.addCriteria(Criteria.where("program_id").is(mealplan.getProgram_id()));
		query.addCriteria(Criteria.where("trainee_id").is(mealplan.getTrainee_id()));
		Update update = new Update();
		update.set("lastUpdatedDate", new Date());

		if (mealplan.getWeeks() != null)
			update.set("weeks", mealplan.getWeeks());
		
		if(mealplan.getTrainer_status() != null)
			update.set("trainer_status", mealplan.getTrainer_status());
		
		if(mealplan.getStartDate() != null)
			update.set("startDate", mealplan.getStartDate());
		
		if(mealplan.getEndDate() != null)
			update.set("endDate", mealplan.getEndDate());
	

		this.mongoTemplate.updateFirst(query, update, MealplanModel.class);
	}
	
	@Override
	public MealplanModel getTraineeMealPlan(String trainee_id, String program_id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("program_id").is(program_id));
		query.addCriteria(Criteria.where("trainee_id").is(trainee_id));
		return mongoTemplate.findOne(query, MealplanModel.class);
	}
	
	@Override
	public MasterMealplanModel getMasterMealPlan(String trainee_id, String program_id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("program_id").is(program_id));
		query.addCriteria(Criteria.where("trainee_id").is(trainee_id));
		return mongoTemplate.findOne(query, MasterMealplanModel.class);
	}
	
	@Override
	public void updateTraineeCalendar(TraineeCalendarModel traineecalendar) {
		Query query = new Query();
		query.addCriteria(Criteria.where("program_id").is(traineecalendar.getProgram_id()));
		query.addCriteria(Criteria.where("trainee_id").is(traineecalendar.getTrainee_id()));
		System.out.println("Request date   "+ traineecalendar.getStartDate());
		Update update = new Update();
		update.set("lastUpdatedDate", new Date());
		if (traineecalendar.getWeeks() != null)
			update.set("weeks", traineecalendar.getWeeks());
		
		if (traineecalendar.getTrainer_status() != null)
			update.set("trainer_status", traineecalendar.getTrainer_status());
		
		if (traineecalendar.getStartDate() != null)
			update.set("startDate", traineecalendar.getStartDate());
		
		if (traineecalendar.getEndDate() != null)
			update.set("endDate", traineecalendar.getEndDate());
		
		
		System.out.println("Update  query "+ update);
		this.mongoTemplate.updateFirst(query, update, TraineeCalendarModel.class);
	}
	
	@Override
	public TraineeCalendarModel getTraineeCalendar(String trainee_id, String program_id) {
		TraineeCalendarModel result = null;
		Query query = new Query();
		query.addCriteria(Criteria.where("trainee_id").is(trainee_id));
		query.addCriteria(Criteria.where("program_id").is(program_id));
		result = mongoTemplate.findOne(query, TraineeCalendarModel.class);
		return result;
	}

	@Override
	public void updateTrainee(TraineeModel trainee) {
		Query query = new Query();
		query.addCriteria(Criteria.where("trainee_id").is(trainee.getTrainee_id()));
		Update update = new Update();
		update.set("program_startdate", trainee.getProgram_startdate());
		this.mongoTemplate.updateFirst(query, update, TraineeModel.class);
		
	}

	@Override
	public void updateMasterMealPlan(MasterMealplanModel mealplan) {
		Query query = new Query();
		query.addCriteria(Criteria.where("program_id").is(mealplan.getProgram_id()));
		query.addCriteria(Criteria.where("trainee_id").is(mealplan.getTrainee_id()));
		Update update = new Update();
		update.set("lastUpdatedDate", new Date());

		if (mealplan.getWeeks() != null)
			update.set("weeks", mealplan.getWeeks());
		
		this.mongoTemplate.updateFirst(query, update, MasterMealplanModel.class);
	}

	@Override
	public void updateSubscription(SubscriptionModel subscriptionModel) {
		Query query = new Query();
		query.addCriteria(Criteria.where("program_id").is(subscriptionModel.getProgram_id()));
		query.addCriteria(Criteria.where("trainee_id").is(subscriptionModel.getTrainee_id()));
		Update update = new Update();
		update.set("program_start_date", subscriptionModel.getProgram_start_date());

		update.set("program_end_date", subscriptionModel.getProgram_end_date());

		update.set("isProgramPublished", subscriptionModel.getIsProgramPublished());

		this.mongoTemplate.updateFirst(query, update, SubscriptionModel.class);
	}

	@Override
	public SelfMealPlan getSelfMeal(String trainee_id, String date) {
		Query query = new Query();
		query.addCriteria(Criteria.where("trainee_id").is(trainee_id));
		query.addCriteria(Criteria.where("date").is(date));
		return this.mongoTemplate.findOne(query, SelfMealPlan.class);
	}
	
	public boolean checkPublishStatus(String trainee_id, String program_id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("program_id").is(program_id));
		query.addCriteria(Criteria.where("trainee_id").is(trainee_id));
		query.fields().include("trainer_status");
		MealplanModel calendar = mongoTemplate.findOne(query, MealplanModel.class);
		if(calendar != null) {
			if(calendar.getTrainer_status() != null && calendar.getTrainer_status().equals("published")) 
				return true;
			else
				return false;
		}else
			return false;
	}
}
