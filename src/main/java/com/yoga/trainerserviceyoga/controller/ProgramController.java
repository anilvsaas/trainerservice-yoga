package com.yoga.trainerserviceyoga.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.yoga.trainerserviceyoga.model.AsanaHistoryModel;
import com.yoga.trainerserviceyoga.model.MealplanModel;
import com.yoga.trainerserviceyoga.model.ProgramModel;
import com.yoga.trainerserviceyoga.model.TraineeCalendarModel;
import com.yoga.trainerserviceyoga.model.TraineeModel;
import com.yoga.trainerserviceyoga.model.TraineeProgressphoto;
import com.yoga.trainerserviceyoga.repo.Program;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/api/trainer/yoga/program")
@Api(value = "YogaTrainerApp", description = "CRUD operations on program")
@CrossOrigin("*")
public class ProgramController {
	private final Program program;

	Map<String, String> errors;
	List<Object> emptyList = new ArrayList<Object>();

	public ProgramController(Program program) {
		this.program = program;
	}

	// Create a program
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Object> addProgram(@RequestBody ProgramModel programModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			errors = new HashMap<>();
			FieldError error = bindingResult.getFieldError();
			return ResponseHandler.generateResponse(HttpStatus.NOT_ACCEPTABLE,
					error.getDefaultMessage() + " in " + error.getField(), "");
		}
		programModel.setCreatedDate(new Date());
		programModel.setLastUpdateOn(new Date());
		ProgramModel p_model = this.program.saveProgram(programModel);
		return ResponseHandler.generateResponse(HttpStatus.OK, "Program created successfully.", p_model.getProgramId());

	}

	// Update a program
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProgram(@RequestBody ProgramModel programModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			errors = new HashMap<>();
			FieldError error = bindingResult.getFieldError();
			return ResponseHandler.generateResponse(HttpStatus.NOT_ACCEPTABLE,
					error.getDefaultMessage() + " in " + error.getField(), "");
		}
		this.program.updateProgram(programModel);
		return ResponseHandler.generateResponse(HttpStatus.OK, "Program updated successfully.", "");
	}

	// Get a program by program id
	@RequestMapping(value = "/{programId}", method = RequestMethod.GET)
	public ResponseEntity<Object> getProgram(@PathVariable String programId) {
		ProgramModel result = this.program.findById(programId);
		return ResponseHandler.generateResponse(HttpStatus.OK, "Program retrieved successfully.", result);
	}

	// Get all program created by a trainer by trainer id
	@RequestMapping(value = "/all/{trainer_id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllProgramsById(@PathVariable String trainer_id, @RequestParam int pagesize,
			@RequestParam int pagenumber, @RequestParam boolean pagination) {
		List<ProgramModel> result = new ArrayList<ProgramModel>();
		if (pagination)
			result = program.getAllProgramsWithPagination(trainer_id, pagesize, pagenumber);
		else
			result = program.getAllProgramsByTrainerId(trainer_id);
		return ResponseHandler.generateResponse(HttpStatus.OK, "Programs retrieved successfully.", result);
	}

	// delete program by id
	@RequestMapping(value = "/{programId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProgram(@PathVariable String programId) {
		this.program.deleteById(programId);
		this.program.delteCalendarByProgramId(programId);
		return ResponseHandler.generateResponse(HttpStatus.OK, "Program deleted successfully.", "");
	}

	// Get all trainees by program id
	@RequestMapping(value = "/{program_id}/trainees/{type}", method = RequestMethod.GET)
	public ResponseEntity<Object> GetAllTrainees(@PathVariable String program_id, @PathVariable String type) {
		List<TraineeModel> result = null;
		result = this.program.getAllTraineesByProgram(program_id, type);
		if (result == null)
			return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "No Trainee found", "");
		else
			return ResponseHandler.generateResponse(HttpStatus.OK, "Trainee retrieved successfully.", result);
	}

	// Get one trainee
	@RequestMapping(value = "/trainee", method = RequestMethod.GET)
	public ResponseEntity<Object> GetTrainee(@RequestParam String trainee_id, @RequestParam String program_id) {
		TraineeModel result = this.program.getTrainee(trainee_id, program_id);
		if (result == null)
			return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "No Trainee found", "");
		else
			return ResponseHandler.generateResponse(HttpStatus.OK, "Trainee retrieved successfully.", result);
	}

	// Get trainee calendar
	@RequestMapping(value = "/{program_id}/calendar/{trainee_id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getTraineeCalendar(@PathVariable String program_id, @PathVariable String trainee_id) {
		TraineeCalendarModel result = this.program.getTraineeCalendar(program_id, trainee_id);
		if (result != null) {
			return ResponseHandler.generateResponse(HttpStatus.OK, "Trainee Calendar retrieved successfully.", result);
		} else {
			return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "No calendar found for this trainee.",
					emptyList);
		}
	}

	// Get all progress photos created by trainee
	@RequestMapping(value = "/{trainee_id}/progressphotos", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllProgressphotos(@PathVariable String trainee_id) {
		List<TraineeProgressphoto> result = this.program.getAllProgressPhotos(trainee_id);
		if (result == null || result.size() == 0)
			return ResponseHandler.generateResponse(HttpStatus.OK, "No photos found for this trainee.", null);
		else
			return ResponseHandler.generateResponse(HttpStatus.OK, "OK", result);
	}

	// Get progress photos by date
	@RequestMapping(value = "/{trainee_id}/progressphotos/limit", method = RequestMethod.POST)
	public ResponseEntity<Object> getProgressphotosByDate(@RequestBody TraineeProgressphoto requestBody) {
		List<TraineeProgressphoto> result = this.program.getProgressPhotosByDate(requestBody.getFromDate(),
				requestBody.getToDate(), requestBody.getTrainee_id());
		if (result == null || result.size() == 0)
			return ResponseHandler.generateResponse(HttpStatus.OK, "No photos found for this trainee.", null);
		else
			return ResponseHandler.generateResponse(HttpStatus.OK, "OK", result);
	}

	// Get trainee workout history
	@RequestMapping(value = "/trainee/asanahistory", method = RequestMethod.POST)
	public ResponseEntity<Object> GetTraineeWorkoutHistory(@RequestBody AsanaHistoryModel request) {
		List<TraineeCalendarModel> result = this.program.getTraineeAsanaHistory(request);
		if (result.size() == 0)
			return ResponseHandler.generateResponse(HttpStatus.OK, "No data found", null);
		else
			return ResponseHandler.generateResponse(HttpStatus.OK, "Data retrieved successfully.", result);
	}

	// Get trainee meal plan history
	@RequestMapping(value = "/trainee/mealplanhistory", method = RequestMethod.POST)
	public ResponseEntity<Object> GetTraineeMealplanHistory(@RequestBody AsanaHistoryModel request) {
		List<MealplanModel> result = this.program.getTraineeMealplanHistory(request);
		if (result.size() == 0)
			return ResponseHandler.generateResponse(HttpStatus.OK, "No data found", null);
		else
			return ResponseHandler.generateResponse(HttpStatus.OK, "Data retrieved successfully.", result);
	}

}
