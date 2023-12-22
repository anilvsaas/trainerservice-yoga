package com.yoga.trainerserviceyoga.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yoga.trainerserviceyoga.model.BusinessDetailsModel;
import com.yoga.trainerserviceyoga.model.TrainerModel;
import com.yoga.trainerserviceyoga.repo.Businessdetails;
import com.yoga.trainerserviceyoga.repo.Trainer;

import io.swagger.annotations.Api;

//@XRayEnabled
@RestController
@RequestMapping(value = "api/trainer/yoga/businessdetails")
@Api(value = "fitness", description = "CRUD operations on business details")
@CrossOrigin("*")
public class Businessdetailscontroller {

    @Autowired
    private Environment env;
    private final Businessdetails businessdetails;
    private final Trainer trainer;
    Map < String, String > errors;
    Map < String, String > responseemptyObject = new HashMap < String, String > ();

    public Businessdetailscontroller(Businessdetails businessdetails, Trainer trainer) {
        this.businessdetails = businessdetails;
        this.trainer =  trainer;
    }


    //Api to check the business details by trainer id created by gangadhar and upadated by gangadhar on 11-06-2020
    @RequestMapping(value = "/{trainerId}", method = RequestMethod.GET)
    public ResponseEntity < Object > getDocumentDetails(@PathVariable String trainerId) {
    	List< BusinessDetailsModel > details = businessdetails.findBytrainerId(trainerId);
        if (details.size()  == 0) {
            return ResponseHandler.generateResponse(HttpStatus.OK, "Please upload your business details", null);
        }
        return ResponseHandler.generateResponse(HttpStatus.OK, "Data retrived successfully", details);
    }
    
    //Api to save the details in database created by gangadhar and updatedby gangadhar 11-06-2020
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity < Object > saveBusinessDetails(@RequestBody BusinessDetailsModel inputbusinessdetails) {
    	inputbusinessdetails.setCreatedOn(new Date());
    	inputbusinessdetails.setUpdatedOn(new Date());
    	businessdetails.saveBusinessDetails(inputbusinessdetails);
    	TrainerModel trmodel = new TrainerModel();
    	trmodel.setTrainerId(inputbusinessdetails.getTrainerId());
    	trmodel.setIsBusinessDetailsSubmitted(true);
    	trainer.updateTrainer(trmodel);
        return ResponseHandler.generateResponse(HttpStatus.OK, "Details saved successfully", null);
    }
    
    //Api to save the details in database created by gangadhar and updatedby gangadhar 11-06-2020
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity < Object > updateBusinessDeatsils(@RequestBody BusinessDetailsModel inputbusinessdetails) {
        businessdetails.update(inputbusinessdetails);
        TrainerModel trmodel = new TrainerModel();
    	trmodel.setTrainerId(inputbusinessdetails.getTrainerId());
    	trmodel.setIsBusinessDetailsSubmitted(true);
    	trainer.updateTrainer(trmodel);
        return ResponseHandler.generateResponse(HttpStatus.OK, "Details updated successfully", null);
    }
}