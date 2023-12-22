package com.yoga.trainerserviceyoga.childmodel.profile;

import java.util.Date;

public class ProfileImage {
	private String profileImageName;
	private String profileImagePath;
	private boolean profileVerfied;
	private Date uploadedOn;

	public String getProfileImageName() {
		return profileImageName;
	}

	public void setProfileImageName(String profileImageName) {
		this.profileImageName = profileImageName;
	}

	public String getProfileImagePath() {
		return profileImagePath;
	}

	public void setProfileImagePath(String profileImagePath) {
		this.profileImagePath = profileImagePath;
	}

	public boolean isProfileVerfied() {
		return profileVerfied;
	}

	public void setProfileVerfied(boolean profileVerfied) {
		this.profileVerfied = profileVerfied;
	}

	public Date getUploadedOn() {
		return uploadedOn;
	}

	public void setUploadedOn(Date uploadedOn) {
		this.uploadedOn = uploadedOn;
	}

}
