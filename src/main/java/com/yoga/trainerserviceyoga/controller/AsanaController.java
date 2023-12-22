package com.yoga.trainerserviceyoga.controller;

import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.yoga.trainerserviceyoga.model.AsanaModel;
import com.yoga.trainerserviceyoga.repo.AsanaInterface;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "api/trainer/yoga/asana")
@Api(value = "YogaTrainerApp", description = "CRUD operations on asana")
@CrossOrigin("*")
public class AsanaController {
	@Autowired
	private AsanaInterface asana;
	Map<String, String> errors;

	// Create an Asana
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Object> saveAsana(@RequestBody AsanaModel asanaModel, BindingResult bindingResult) {
		try {
		if (bindingResult.hasErrors()) {
			errors = new HashMap<>();
			FieldError error = bindingResult.getFieldError();
			return ResponseHandler.generateResponse(HttpStatus.NOT_ACCEPTABLE,
					error.getDefaultMessage() + " in " + error.getField(), "");
		}
		asanaModel.setCreationDate(new Date());
		asanaModel.setLastUpdatedDate(new Date());
		this.asana.saveAsana(asanaModel);
		return ResponseHandler.generateResponse(HttpStatus.OK, "Asana saved successfully.", null);
		}catch(Exception e) {
		 return ResponseHandler.generateResponse(HttpStatus.OK, "Something went wrong please try again latter.", null);
		}
	}

	// Get an Asana
	@RequestMapping(value = "/{asanaId}", method = RequestMethod.GET)
	public ResponseEntity<Object> getAsana(@PathVariable String asanaId) {
		AsanaModel asanaResult = this.asana.getAsana(asanaId);
		if(asanaResult != null)
		return ResponseHandler.generateResponse(HttpStatus.OK, "Asana retrieved successfully.", asanaResult);
		else
			return ResponseHandler.generateResponse(HttpStatus.OK, "No Asana found with this id.", null);	
	}

	// Update an Asana
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateAsana(@RequestBody AsanaModel asanaModel) {
		asanaModel.setLastUpdatedDate(new Date());
		this.asana.updateAsana(asanaModel);
		return ResponseHandler.generateResponse(HttpStatus.OK, "Asana updated successfully.", "");
	}

	// Delete an Asana
	@RequestMapping(value = "/{asanaId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteAsana(@PathVariable String asanaId) {
		this.asana.deleteAsana(asanaId);
		return ResponseHandler.generateResponse(HttpStatus.OK, "Asana deleted successfully.", "");
	}

	// Get all Asanas
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllAsanasByTrainer(@RequestParam String trainerId) {
		List<AsanaModel> asanaList = this.asana.getAllAsanas(trainerId);
		if(asanaList.size() != 0)
		return ResponseHandler.generateResponse(HttpStatus.OK, "Asanas successfully.", asanaList);
		else
			return ResponseHandler.generateResponse(HttpStatus.OK, "Asanas successfully.", null);
	}
	
}
