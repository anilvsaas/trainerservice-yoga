package com.yoga.trainerserviceyoga.childmodel.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FullNutrient {
	@JsonProperty("attr_id")
	private Integer attrId;
	@JsonProperty("value")
	private Double value;

	@JsonProperty("attr_id")
	public Integer getAttrId() {
		return attrId;
	}

	@JsonProperty("attr_id")
	public void setAttrId(Integer attrId) {
		this.attrId = attrId;
	}

	@JsonProperty("value")
	public Double getValue() {
		return value;
	}

	@JsonProperty("value")
	public void setValue(Double value) {
		this.value = value;
	}
}
