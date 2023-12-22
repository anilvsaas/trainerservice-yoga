package com.yoga.trainerserviceyoga.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "business_details")
public class BusinessDetailsModel {


	@Id
	private String id;
	private String trainerId;
	private Bankaccountdetails bankAccountDetails;
	private List<BusinessDocuments> businessDocuments;
	private Date updatedOn;
    private Date createdOn;
	
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	public Bankaccountdetails getBankAccountDetails() {
		return bankAccountDetails;
	}

	public void setBankAccountDetails(Bankaccountdetails bankAccountDetails) {
		this.bankAccountDetails = bankAccountDetails;
	}


	public List<BusinessDocuments> getBusinessDocuments() {
		return businessDocuments;
	}

	public void setBusinessDocuments(List<BusinessDocuments> businessDocuments) {
		this.businessDocuments = businessDocuments;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}


}
