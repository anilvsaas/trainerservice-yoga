package com.yoga.trainerserviceyoga.childmodel.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Metadata {
	@JsonProperty("is_raw_food")
	private Boolean isRawFood;

	@JsonProperty("is_raw_food")
	public Boolean getIsRawFood() {
		return isRawFood;
	}

	@JsonProperty("is_raw_food")
	public void setIsRawFood(Boolean isRawFood) {
		this.isRawFood = isRawFood;
	}
}
