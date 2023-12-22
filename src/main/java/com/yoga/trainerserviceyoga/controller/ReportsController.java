package com.yoga.trainerserviceyoga.controller;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yoga.trainerserviceyoga.childmodel.ChartModel;
import com.yoga.trainerserviceyoga.childmodel.TrainerSlot;
import com.yoga.trainerserviceyoga.model.MealplanModel;
import com.yoga.trainerserviceyoga.model.ProgramModel;
import com.yoga.trainerserviceyoga.model.ReportsModel;
import com.yoga.trainerserviceyoga.model.SubscriptionModel;
import com.yoga.trainerserviceyoga.repo.Program;
import com.yoga.trainerserviceyoga.repo.Reports;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/api/trainer/yoga/reports")
@Api(value = "fitness", description = "CRUD operations on reports")
@CrossOrigin("*")
public class ReportsController {

	@Autowired
	private Environment env;
	private final Reports reports;
	private final Program program;
	Map<String, String> errors;
	List<Object> emptyList = new ArrayList<Object>();
	Date date = new Date();
	Calendar cal = Calendar.getInstance();

	public ReportsController(Reports reports, Program program) {
		this.reports = reports;
		this.program = program;
	}

	// This is for dummy test to check controller working or not created by
	// gangadhar,updated by gangadhar.
	@RequestMapping("/dummytest")
	public String homeAdmin() {
		return "This is the test area of apigateway service running at port: " + env.getProperty("local.server.port");
	}

	// Get calendar data created by trainerId
	@RequestMapping(value = "/{trainerId}", method = RequestMethod.GET)
	public ResponseEntity<Object> getReports(@PathVariable String trainerId, @RequestParam String reportsFor) {

		if (reportsFor.equals("subscriptions")) {
//	 			List<ProgramModel> programs	 = program.getAllProgramsByTrainerId(trainerId);
			List<ProgramModel> programs = reports.getProgramstatus(trainerId, "Approved");
			List<ReportsModel> reportData = new ArrayList<ReportsModel>();
			if (programs.size() == 0)
				return ResponseHandler.generateResponse(HttpStatus.OK, "There are no program to generate reports",
						reportData);
			else {
				for (int i = 0; i < programs.size(); i++) {
					List<SubscriptionModel> Acivesubscription = reports.getSubscriptions(programs.get(i).getProgramId(),
							"Active");
					List<SubscriptionModel> Inactivesubscription = reports
							.getSubscriptions(programs.get(i).getProgramId(), "Inactive");
					List<ChartModel> seriesarray = new ArrayList<ChartModel>();
					ReportsModel generatedReports = new ReportsModel();
					for (int j = 0; j < 2; j++) {
						if (j == 0) {
							ChartModel chartsvalue = new ChartModel();
							chartsvalue.setName("Active subscriptions");
							chartsvalue.setValue(BigDecimal.valueOf(Acivesubscription.size()));
							seriesarray.add(chartsvalue);
						} else {
							ChartModel chartsvalue = new ChartModel();
							chartsvalue.setName("Inactive subscriptions");
							chartsvalue.setValue(BigDecimal.valueOf(Inactivesubscription.size()));
							seriesarray.add(chartsvalue);
						}
					}
					generatedReports.setName(programs.get(i).getProgramName());
					generatedReports.setSeries(seriesarray);
					reportData.add(generatedReports);
				}
			}
			return ResponseHandler.generateResponse(HttpStatus.OK, "reports generated successfully", reportData);

		} else if (reportsFor.equals("Calls")) {
			List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July",
					"August", "September", "October", "November", "December");
			int month = cal.get(Calendar.MONTH);
			int year = cal.get(Calendar.YEAR);
			List<ReportsModel> reportData = new ArrayList<ReportsModel>();
			for (int i = 0; i <= month; i++) {
				List<ChartModel> seriesarray = new ArrayList<ChartModel>();
				List<TrainerSlot> oneononetrainerslots = reports.getTrainerslots(trainerId, months.get(i) + "/" + year,
						"1o1");
				List<TrainerSlot> grouptraienrslots = reports.getTrainerslots(trainerId, months.get(i) + "/" + year,
						"group");
				ReportsModel generatedReports = new ReportsModel();
				long oneoneoneminutes = 0;
				long groupminutes = 0;
				if (oneononetrainerslots.size() != 0) {
					for (int k = 0; k < oneononetrainerslots.size(); k++) {
						long numberOnly = Long.parseLong(oneononetrainerslots.get(k).getRoomDuration()) / 60;
//	 					 long numberOnly= Long.parseLong(oneononetrainerslots.get(k).getFrequency().getName().replaceAll("[^0-9]", ""));
						oneoneoneminutes = oneoneoneminutes + numberOnly;
					}
				} else
					oneoneoneminutes = 0;
				if (grouptraienrslots.size() != 0) {
					for (int l = 0; l < grouptraienrslots.size(); l++) {
						long numberOnly = Long.parseLong(grouptraienrslots.get(l).getRoomDuration()) / 60;
//	 					long numberOnly = Long.parseLong(oneononetrainerslots.get(l).getFrequency().getName().replaceAll("[^0-9]", ""));
						groupminutes = groupminutes + numberOnly;
					}
				} else
					groupminutes = 0;
				for (int j = 0; j < 2; j++) {
					if (j == 0) {
						ChartModel chartsvalue = new ChartModel();
						chartsvalue.setName("1o1");
						chartsvalue.setValue(BigDecimal.valueOf(oneoneoneminutes));
						seriesarray.add(chartsvalue);
					} else {
						ChartModel chartsvalue = new ChartModel();
						chartsvalue.setName("1o1-group");
						chartsvalue.setValue(BigDecimal.valueOf(groupminutes));
						seriesarray.add(chartsvalue);
					}
				}
				generatedReports.setName(months.get(i));
				generatedReports.setSeries(seriesarray);
				reportData.add(generatedReports);
			}
			return ResponseHandler.generateResponse(HttpStatus.OK, "reports generated successfully", reportData);

		} else if (reportsFor.equals("programs")) {
			List<ChartModel> reportData = new ArrayList<ChartModel>();
			List<ProgramModel> activeprograms = reports.getProgramstatus(trainerId, "Approved");
			List<ProgramModel> waitingforapprovalprograms = reports.getProgramstatus(trainerId, "Other");
			List<ProgramModel> unpublishedprograms = reports.getProgramstatus(trainerId, "New");
			for (int i = 0; i < 3; i++) {
				if (i == 0) {
					ChartModel chartsvalue = new ChartModel();
					chartsvalue.setName("Active programs");
					chartsvalue.setValue(BigDecimal.valueOf(activeprograms.size()));
					reportData.add(chartsvalue);
				} else if (i == 1) {
					ChartModel chartsvalue = new ChartModel();
					chartsvalue.setName("Approval waiting programs");
					chartsvalue.setValue(BigDecimal.valueOf(waitingforapprovalprograms.size()));
					reportData.add(chartsvalue);
				} else {
					ChartModel chartsvalue = new ChartModel();
					chartsvalue.setName("Unpublished programs");
					chartsvalue.setValue(BigDecimal.valueOf(unpublishedprograms.size()));
					reportData.add(chartsvalue);
				}
			}
			return ResponseHandler.generateResponse(HttpStatus.OK, "reports generated successfully", reportData);
		} else if (reportsFor.equals("Totalrevenue")) {
//	 			List<ProgramModel> programs = program.getAllProgramsByTrainerId(trainerId); 
			List<ProgramModel> programs = reports.getProgramstatus(trainerId, "Approved");
			List<ReportsModel> reportData = new ArrayList<ReportsModel>();
			if (programs.size() == 0)
				return ResponseHandler.generateResponse(HttpStatus.OK, "There are no program to generate reports",
						reportData);
			else {
				for (int i = 0; i < programs.size(); i++) {
					List<ChartModel> seriesarray = new ArrayList<ChartModel>();
					ReportsModel generatedReports = new ReportsModel();
					List<SubscriptionModel> priceIndollars = reports.getSubscriptions(programs.get(i).getProgramId(),
							"Dollars");
					List<SubscriptionModel> priceInRupees = reports.getSubscriptions(programs.get(i).getProgramId(),
							"Rupees");
					List<SubscriptionModel> refundIndollars = reports.getSubscriptions(programs.get(i).getProgramId(),
							"RefundDollars");
					List<SubscriptionModel> refundInrupees = reports.getSubscriptions(programs.get(i).getProgramId(),
							"RefundRupees");
					for (int j = 0; j < 4; j++) {
						if (j == 0) {
							ChartModel chartsvalue = new ChartModel();
							chartsvalue.setName("Price in rupees");
							if (priceInRupees.size() == 0)
								chartsvalue.setValue(BigDecimal.valueOf(priceInRupees.size()));
							else {
								double value = 0;
								for (int k = 0; k < priceInRupees.size(); k++) {
									value = value + priceInRupees.get(k).getPriceWithTax();
								}
								chartsvalue.setValue(BigDecimal.valueOf(value));
							}
							seriesarray.add(chartsvalue);
						} else if (j == 1) {
							ChartModel chartsvalue = new ChartModel();
							chartsvalue.setName("Price in dollars");
							if (priceIndollars.size() == 0)
								chartsvalue.setValue(BigDecimal.valueOf(priceIndollars.size()));
							else {
								double value = 0;
								for (int k = 0; k < priceIndollars.size(); k++) {
									value = value + priceIndollars.get(k).getPriceWithTax();
								}
								chartsvalue.setValue(BigDecimal.valueOf(value));
							}
							seriesarray.add(chartsvalue);
						} else if (j == 2) {
							ChartModel chartsvalue = new ChartModel();
							chartsvalue.setName("Refund in dollars");
							if (refundIndollars.size() == 0)
								chartsvalue.setValue(BigDecimal.valueOf(refundIndollars.size()));
							else {
								double value = 0;
								for (int k = 0; k < refundIndollars.size(); k++) {
									value = value + refundIndollars.get(k).getPriceWithTax();
								}
								chartsvalue.setValue(BigDecimal.valueOf(value));
							}
							seriesarray.add(chartsvalue);
						} else {
							ChartModel chartsvalue = new ChartModel();
							chartsvalue.setName("Refund in rupees");
							if (refundInrupees.size() == 0)
								chartsvalue.setValue(BigDecimal.valueOf(refundInrupees.size()));
							else {
								double value = 0;
								for (int k = 0; k < refundInrupees.size(); k++) {
									value = value + refundInrupees.get(k).getPriceWithTax();
								}
								chartsvalue.setValue(BigDecimal.valueOf(value));
							}
							seriesarray.add(chartsvalue);
						}
					}
					generatedReports.setName(programs.get(i).getProgramName());
					generatedReports.setSeries(seriesarray);
					reportData.add(generatedReports);
				}
			}
			return ResponseHandler.generateResponse(HttpStatus.OK, "reports generated successfully", reportData);
		} else if (reportsFor.equals("Calendars")) {
//	 			List<ProgramModel> programs = program.getAllProgramsByTrainerId(trainerId); 
			List<ProgramModel> programs = reports.getProgramstatus(trainerId, "Approved");
			List<ReportsModel> reportData = new ArrayList<ReportsModel>();
			if (programs.size() == 0)
				return ResponseHandler.generateResponse(HttpStatus.OK, "There are no program to generate reports",
						reportData);
			else {
				for (int i = 0; i < programs.size(); i++) {
					List<ChartModel> seriesarray = new ArrayList<ChartModel>();
					ReportsModel generatedReports = new ReportsModel();
					List<SubscriptionModel> subscriptions = reports.getSubscriptions(programs.get(i).getProgramId(),
							"Active");
					List<SubscriptionModel> Publishedcount = reports.getSubscriptions(programs.get(i).getProgramId(),
							"published");
					List<MealplanModel> traineemealplan = new ArrayList<MealplanModel>();
					;
					if (subscriptions.size() == 0)
						traineemealplan = new ArrayList<MealplanModel>();
					else {
						for (int j = 0; j < subscriptions.size(); j++) {
							MealplanModel activatedMealplan = reports.gettraineemealplan(
									subscriptions.get(j).getProgram_id(), subscriptions.get(j).getTrainee_id(),
									"published");
							if (activatedMealplan != null)
								traineemealplan.add(activatedMealplan);
						}
					}
					for (int k = 0; k < 3; k++) {
						if (k == 0) {
							ChartModel chartsvalue = new ChartModel();
							chartsvalue.setName("Active subscriptions");
							chartsvalue.setValue(BigDecimal.valueOf(subscriptions.size()));
							seriesarray.add(chartsvalue);
						} else if (k == 1) {
							ChartModel chartsvalue = new ChartModel();
							chartsvalue.setName("Published workouts");
							chartsvalue.setValue(BigDecimal.valueOf(Publishedcount.size()));
							seriesarray.add(chartsvalue);
						} else {
							ChartModel chartsvalue = new ChartModel();
							chartsvalue.setName("Published mealplans");
							chartsvalue.setValue(BigDecimal.valueOf(traineemealplan.size()));
							seriesarray.add(chartsvalue);
						}
					}
					generatedReports.setName(programs.get(i).getProgramName());
					generatedReports.setSeries(seriesarray);
					reportData.add(generatedReports);
				}
			}
			return ResponseHandler.generateResponse(HttpStatus.OK, "reports generated successfully", reportData);
		}
		return ResponseHandler.generateResponse(HttpStatus.OK, "Failed to generate reports for:" + reportsFor,
				emptyList);
	}

}