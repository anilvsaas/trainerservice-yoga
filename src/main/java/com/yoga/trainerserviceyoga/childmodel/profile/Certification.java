package com.yoga.trainerserviceyoga.childmodel.profile;

public class Certification {
	private String id;
	private String name;
	private String uploadedCertificateName;
	private String certificateDestinationUploadUrl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUploadedCertificateName() {
		return uploadedCertificateName;
	}

	public void setUploadedCertificateName(String uploadedCertificateName) {
		this.uploadedCertificateName = uploadedCertificateName;
	}

	public String getCertificateDestinationUploadUrl() {
		return certificateDestinationUploadUrl;
	}

	public void setCertificateDestinationUploadUrl(String certificateDestinationUploadUrl) {
		this.certificateDestinationUploadUrl = certificateDestinationUploadUrl;
	}
}
