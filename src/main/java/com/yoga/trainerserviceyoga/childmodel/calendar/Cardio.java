package com.yoga.trainerserviceyoga.childmodel.calendar;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yoga.trainerserviceyoga.childmodel.Comment;
import com.yoga.trainerserviceyoga.childmodel.SetValue;
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Cardio {
	
	private String name;
	private String imgUrl;
	private String metrics;
	private SetValue distance;
	private List<Comment> cardioComments;
	private String cardioStatus;
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCardioStatus() {
		return cardioStatus;
	}

	public void setCardioStatus(String cardioStatus) {
		this.cardioStatus = cardioStatus;
	}

	public SetValue getDistance() {
		return distance;
	}

	public void setDistance(SetValue distance) {
		this.distance = distance;
	}

	public List<Comment> getCardioComments() {
		return cardioComments;
	}

	public void setCardioComments(List<Comment> cardioComments) {
		this.cardioComments = cardioComments;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getMetrics() {
		return metrics;
	}

	public void setMetrics(String metrics) {
		this.metrics = metrics;
	}
}
