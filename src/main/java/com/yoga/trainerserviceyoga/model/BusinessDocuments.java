package com.yoga.trainerserviceyoga.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

public class BusinessDocuments {
	private String name;
	private String documentType;
	private String uploadedDocumentName;
	private String documentDestionationUploadUrl;
	private boolean documentVerified;

	private Date uploadedOn = new Date();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getUploadedDocumentName() {
		return uploadedDocumentName;
	}
	public void setUploadedDocumentName(String uploadedDocumentName) {
		this.uploadedDocumentName = uploadedDocumentName;
	}
	public String getDocumentDestionationUploadUrl() {
		return documentDestionationUploadUrl;
	}
	public void setDocumentDestionationUploadUrl(String documentDestionationUploadUrl) {
		this.documentDestionationUploadUrl = documentDestionationUploadUrl;
	}
	public boolean isDocumentVerified() {
		return documentVerified;
	}
	public void setDocumentVerified(boolean documentVerified) {
		this.documentVerified = documentVerified;
	}
	public Date getUploadedOn() {
		return uploadedOn;
	}
	public void setUploadedOn(Date uploadedOn) {
		this.uploadedOn = uploadedOn;
	}

}
