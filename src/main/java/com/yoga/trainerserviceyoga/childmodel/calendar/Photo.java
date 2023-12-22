package com.yoga.trainerserviceyoga.childmodel.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Photo {
	@JsonProperty("thumb")
	private String thumb;
	@JsonProperty("highres")
	private String highres;
	@JsonProperty("is_user_uploaded")
	private Boolean isUserUploaded;

	@JsonProperty("thumb")
	public String getThumb() {
		return thumb;
	}

	@JsonProperty("thumb")
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	@JsonProperty("highres")
	public String getHighres() {
		return highres;
	}

	@JsonProperty("highres")
	public void setHighres(String highres) {
		this.highres = highres;
	}

	@JsonProperty("is_user_uploaded")
	public Boolean getIsUserUploaded() {
		return isUserUploaded;
	}

	@JsonProperty("is_user_uploaded")
	public void setIsUserUploaded(Boolean isUserUploaded) {
		this.isUserUploaded = isUserUploaded;
	}
}
