package com.yoga.trainerserviceyoga.controller;

import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RestController;

import com.yoga.trainerserviceyoga.model.CalendarModel;
import com.yoga.trainerserviceyoga.repo.Calendar;

import io.swagger.annotations.Api;
//@XRayEnabled
@RestController
@RequestMapping(value = "/api/trainer/yoga/calendar")
@Api(value = "fitness", description = "CRUD operations on calendar")
@CrossOrigin("*")
public class CalendarController {
	public final Calendar calendar;

	Map<String, String> errors;

	public CalendarController(Calendar calendar) {
		this.calendar = calendar;
	}

	// Create a calendar
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Object> addCalendar(@RequestBody CalendarModel calendarModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			errors = new HashMap<>();
			FieldError error = bindingResult.getFieldError();
			return ResponseHandler.generateResponse(HttpStatus.NOT_ACCEPTABLE,
					error.getDefaultMessage() + " in " + error.getField(), "");
		}
		calendarModel.setCreationDate(new Date());
		calendarModel.setLastUpdatedDate(new Date());
		this.calendar.saveCalendar(calendarModel);
		return ResponseHandler.generateResponse(HttpStatus.OK, "Calendar created successfully.", "");
	}

	// Create a calendar
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateCalendar(@RequestBody CalendarModel calendarModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			errors = new HashMap<>();
			FieldError error = bindingResult.getFieldError();
			return ResponseHandler.generateResponse(HttpStatus.NOT_ACCEPTABLE,
					error.getDefaultMessage() + " in " + error.getField(), "");
		}
		this.calendar.updateCalendar(calendarModel);
	//	this.calendar.updateCalendarDependencies(calendarModel);
		return ResponseHandler.generateResponse(HttpStatus.OK, "Calendar updated successfully.", "");
	}

	// Get calendar data program id
	@RequestMapping(value = "/{programId}", method = RequestMethod.GET)
	public ResponseEntity<Object> getCalendar(@PathVariable String programId) {
		CalendarModel result = this.calendar.getCalendarByProgramId(programId);
		if (result != null) {
			return ResponseHandler.generateResponse(HttpStatus.OK, "Calendar retrieved successfully.", result);
		} else {
			return ResponseHandler.generateResponse(HttpStatus.OK, "No calendar data for this program.", "");
		}
	}

	// Delete calendar data calendar id
	@RequestMapping(value = "/{calendarId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCalendar(@PathVariable String calendarId) {
		this.calendar.deleteById(calendarId);
		return ResponseHandler.generateResponse(HttpStatus.OK, "Calendar deleted successfully.", "");
	}
}
