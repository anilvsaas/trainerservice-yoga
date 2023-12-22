package com.yoga.trainerserviceyoga.childmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AltMeasure {
	@JsonProperty("serving_weight")
	private Double servingWeight;
	@JsonProperty("measure")
	private String measure;
	@JsonProperty("seq")
	private Integer seq;
	@JsonProperty("qty")
	private Integer qty;

	@JsonProperty("serving_weight")
	public Double getServingWeight() {
		return servingWeight;
	}

	@JsonProperty("serving_weight")
	public void setServingWeight(Double servingWeight) {
		this.servingWeight = servingWeight;
	}

	@JsonProperty("measure")
	public String getMeasure() {
		return measure;
	}

	@JsonProperty("measure")
	public void setMeasure(String measure) {
		this.measure = measure;
	}

	@JsonProperty("seq")
	public Integer getSeq() {
		return seq;
	}

	@JsonProperty("seq")
	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	@JsonProperty("qty")
	public Integer getQty() {
		return qty;
	}

	@JsonProperty("qty")
	public void setQty(Integer qty) {
		this.qty = qty;
	}
}
