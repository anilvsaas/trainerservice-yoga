package com.yoga.trainerserviceyoga.model;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "datetest")
public class TestDateModel {
	@Id
	private String id;
	private Date date;
	@CreatedDate
	private Date creationDate;
	@LastModifiedDate
	private Date updationDate;
	private LocalDateTime localeTime;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss'Z'")
	private LocalDateTime jacksonDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdationDate() {
		return updationDate;
	}

	public void setUpdationDate(Date updationDate) {
		this.updationDate = updationDate;
	}

	public LocalDateTime getLocaleTime() {
		return localeTime;
	}

	public void setLocaleTime(LocalDateTime localeTime) {
		this.localeTime = localeTime;
	}

	public LocalDateTime getJacksonDate() {
		return jacksonDate;
	}

	public void setJacksonDate(LocalDateTime jacksonDate) {
		this.jacksonDate = jacksonDate;
	}

}
