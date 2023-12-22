package com.yoga.trainerserviceyoga.controller;
import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yoga.trainerserviceyoga.model.Constants;
import com.yoga.trainerserviceyoga.model.TraineeModel;
import com.yoga.trainerserviceyoga.model.TrainerModel;
import com.yoga.trainerserviceyoga.repo.Trainer;

import io.swagger.annotations.Api;


@RestController
@RequestMapping(value = "api/trainer/yoga/profile")
@Api(value = "YogaTrainerApp", description = "CRUD operations on trainer profile")
@CrossOrigin("*")
public class TrainerProfileController {

	private final Trainer trainer;

	Map<String,String> errors ;
	
	public TrainerProfileController(Trainer trainer) {
		this.trainer = trainer;
	}

	// Create a trainer
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Object> addTrainer(@RequestBody TrainerModel trainerModel, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			errors = new HashMap<>(); 
			FieldError error = bindingResult.getFieldError(); 
			return ResponseHandler.generateResponse(HttpStatus.NOT_ACCEPTABLE, error.getDefaultMessage()+" in "+error.getField(), "");
		}
		trainerModel.setCreationDate(new Date());
		trainerModel.setLastUpdatedDate(new Date());
		trainerModel.getProfileImage().setUploadedOn(new Date());
		trainerModel.getProfileIntroVideo().setVideouploadedOn(new Date());
		trainerModel.setServiceFee(Constants.service_fee);
		TrainerModel trainer = this.trainer.saveTrainer(trainerModel);
		if(trainer == null) {
			return ResponseHandler.generateResponse(HttpStatus.OK, "User already exist.", null);
		}else {
			return ResponseHandler.generateResponse(HttpStatus.OK, "Trainer created successfully.", trainer);
		}
		
	}

	// Update a trainer
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateTrainer(@RequestBody TrainerModel trainerModel, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			errors = new HashMap<>(); 
			FieldError error = bindingResult.getFieldError(); 
			return ResponseHandler.generateResponse(HttpStatus.NOT_ACCEPTABLE, error.getDefaultMessage()+" in "+error.getField(), "");
		}
		this.trainer.updateTrainer(trainerModel);
		return ResponseHandler.generateResponse(HttpStatus.OK, "Trainer updated successfully.", "");
	}

	// Get a trainer by id or id's
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getTtainer(@PathVariable String id) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);
		boolean result = pat.matcher(id).matches();
		if (result == true) {
			List<TrainerModel> list = new ArrayList<TrainerModel>();
			list.add(trainer.getTrainerByUserName(id));
			return ResponseHandler.generateResponse(HttpStatus.OK, "Trainer retrived successfully.", list);
		} else {
			List<TrainerModel> list = trainer.getAllTrainers(id);
			return ResponseHandler.generateResponse(HttpStatus.OK, "Trainers retrived successfully.", list);
		}
	}

	// Get trainer data with
	// userId,imgPath,firstName,lastName,mp4Destination,thumbnailDestination,city
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllTrainers() {
		List<TrainerModel> list = this.trainer.getTrainers();
		return ResponseHandler.generateResponse(HttpStatus.OK, "Trainer retrived successfully.", list);
	}

	// Delete a trainer
	@RequestMapping(value = "/{trainerId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteTrainer(@PathVariable String trainerId) {
		this.trainer.deleteById(trainerId);
		return ResponseHandler.generateResponse(HttpStatus.OK, "Trainer deleted successfully.", "");
	}
	
	   //Get all trainees by list
		@RequestMapping(value = "/trainees/{trainee_ids}", method = RequestMethod.GET)
		public ResponseEntity<Object> getTrainees(@PathVariable String trainee_ids) {
			List<TraineeModel> result = this.trainer.getTrainees(trainee_ids);
			return ResponseHandler.generateResponse(HttpStatus.OK, "Trainees retrieved successfully.", result);
		}
		
		// Get a trainer by id or id's
		@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
		public ResponseEntity<Object> getTtainers(@PathVariable String id) {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
					+ "A-Z]{2,7}$";
			Pattern pat = Pattern.compile(emailRegex);
			boolean result = pat.matcher(id).matches();
			if (result == true) {
				List<TrainerModel> list = trainer.getAllTrainersByUserName(id);
				return ResponseHandler.generateResponse(HttpStatus.OK, "Trainer retrived successfully.", list);
			} else {
				List<TrainerModel> list = trainer.getAllTrainersByCategory(id);
				return ResponseHandler.generateResponse(HttpStatus.OK, "Trainers retrived successfully.", list);
			}
		}


}
