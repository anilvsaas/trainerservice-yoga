package com.yoga.trainerserviceyoga.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yoga.trainerserviceyoga.childmodel.calendar.MealPlan;
import com.yoga.trainerserviceyoga.repo.MasterMealInterface;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "api/trainer/yoga/mastermeal")
@Api(value = "fitness", description = "CRUD operations on masters meal plan")
@CrossOrigin("*")
public class MasterMealplanController {
	private final MasterMealInterface masterMeal;

	public MasterMealplanController(MasterMealInterface masterMeal) {
		this.masterMeal = masterMeal;
	}

	// Save master meal plan
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Object> saveMasterMealPlan(@RequestBody MealPlan meal) {
		String result = this.masterMeal.saveMealPlan(meal);
		if(result == null)
			return ResponseHandler.generateResponse(HttpStatus.OK, "OK.", null);
		else
		    return ResponseHandler.generateResponse(HttpStatus.OK, "OK.", "");
	}

	// Update master meal plan
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateMasterMealPlan(@RequestBody MealPlan meal) {
		this.masterMeal.updateMealPlan(meal);
		return ResponseHandler.generateResponse(HttpStatus.OK, "OK.", null);
	}

	// Get single meal plan
	@RequestMapping(value = "/{mealId}", method = RequestMethod.GET)
	public ResponseEntity<Object> getMasterMealplan(@PathVariable String mealId) {
		MealPlan result = this.masterMeal.getMealPlan(mealId);
		return ResponseHandler.generateResponse(HttpStatus.OK, "OK.", result);
	}
	
	// Delete single meal plan
		@RequestMapping(value = "/{mealId}", method = RequestMethod.DELETE)
		public ResponseEntity<Object> deleteMasterMealplan(@PathVariable String mealId) {
			this.masterMeal.deleteMasterMeal(mealId);
			return ResponseHandler.generateResponse(HttpStatus.OK, "OK.", null);
		}

	// Get all meal plans created by trainer
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllMasterMeals(@RequestParam String trainerId) {
		List<MealPlan> result = this.masterMeal.getMealPlans(trainerId);
		return ResponseHandler.generateResponse(HttpStatus.OK, "OK.", result);
	}
}
