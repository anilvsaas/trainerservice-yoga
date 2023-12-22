package com.yoga.trainerserviceyoga.repo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.yoga.trainerserviceyoga.childmodel.calendar.MealPlan;


@Repository
public class MasterMealplanImpl implements MasterMealInterface{
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public String saveMealPlan(MealPlan mealplan) {
		mealplan.setCreatedOn(new Date());
		mealplan.setLastUpdatedOn(new Date());
		mealplan.setMealName(mealplan.getMealName().trim());
		Criteria regex = Criteria.where("mealName").regex(".*"+mealplan.getMealName().toLowerCase()+".*", "i");   
		Query query = new Query();
		query.addCriteria(regex);
		query.addCriteria(Criteria.where("trainerId").is(mealplan.getTrainerId()));
		MealPlan meal = this.mongoTemplate.findOne(query, MealPlan.class);
		if(meal == null) {
		this.mongoTemplate.save(mealplan);
		return "OK.";
		}
		else
			return null;
	}

	@Override
	public MealPlan getMealPlan(String mealId) {
		Query query =  new Query();
		query.addCriteria(Criteria.where("mealId").is(mealId));
		return this.mongoTemplate.findOne(query, MealPlan.class);
	}

	@Override
	public MealPlan updateMealPlan(MealPlan mealplan) {
		Query query = new Query();
		query.addCriteria(Criteria.where("mealId").is(mealplan.getMealId()));
		Update update = new Update();
		update.set("lastUpdatedOn", new Date());
		update.set("breakfast", mealplan.getBreakfast());
		update.set("lunch", mealplan.getLunch());
		update.set("snacks", mealplan.getSnacks());
		update.set("dinner", mealplan.getDinner());
		update.set("overall_protein_recommended", mealplan.getOverall_protein_recommended());
		update.set("overall_carboHydrate_recommended", mealplan.getOverall_carboHydrate_recommended());
		update.set("overall_fibre_recommended", mealplan.getOverall_fibre_recommended());
		update.set("overall_fat_recommended", mealplan.getOverall_fat_recommended());
		update.set("overall_calories_recommended", mealplan.getOverall_calories_recommended());
		update.set("mealName", mealplan.getMealName());
		update.set("macros", mealplan.getMacros());
		MealPlan result = this.mongoTemplate.findAndModify(query, update, MealPlan.class);
//		update.set("overall_protein_consumed", mealplan.getOverall_protein_consumed());
//		update.set("overall_carboHydrate_consumed", mealplan.getOverall_carboHydrate_consumed());
//		update.set("overall_fibre_consumed", mealplan.getOverall_fibre_consumed());
//		update.set("overall_fat_consumed", mealplan.getOverall_fat_consumed());
//		update.set("overall_calories_consumed", mealplan.getOverall_calories_consumed());
//		update.set("mealPlanStatus", mealplan.getMealPlanStatus());
		
		return result;
	}

	@Override
	public List<MealPlan> getMealPlans(String trainerId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("trainerId").is(trainerId));
		return this.mongoTemplate.find(query, MealPlan.class);
	}

	@Override
	public void deleteMasterMeal(String mealId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("mealId").is(mealId));
		this.mongoTemplate.remove(query, MealPlan.class);
	}

}
