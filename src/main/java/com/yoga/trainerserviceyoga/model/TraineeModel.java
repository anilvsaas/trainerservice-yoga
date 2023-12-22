package com.yoga.trainerserviceyoga.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yoga.trainerserviceyoga.childmodel.profile.Bmi_bmr;
import com.yoga.trainerserviceyoga.childmodel.profile.TraineeAddress;
import com.yoga.trainerserviceyoga.childmodel.profile.TraineeProfileImage;


//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Document(collection = "trainees")
public class TraineeModel {
	private String trainee_id;
	private String first_name;
	private String last_name;
	private String trainee_profile_staus;
	private String mobile_no;
	private String gender;
	private Date date_of_birth;
	private int age;
	private Object currrent_weight;
	private Object trainee_height;
	private String activity_level;
	private String primary_goal;
	private Object best_workout_day;
	private Object food_preference;
	private Object smoke_alcohol_consumption;
	private String sleep_duration;
	private String sleep_quality;
	private Object medical_history;
	private Object previous_workout_history;
	private String trainee_timezone;
	private List<TraineeAddress> trainee_address;
	private Object lat_logAttributes;
    private Date created_on;
	private Date updated_on;
	private String program_id;
	private Date program_startdate;
	private String email;
	private String country_code;
	private String username;
	private boolean address_submission;
	private boolean profile_submission;
	private double app_version = 0.0;
	private String user_type;
	private TraineeProfileImage traineeProfileImg;
	private Bmi_bmr bmi_bmr;
	private Object targetWeight;
	@Transient
	private boolean isProgramActive;
	
	public boolean getIsProgramActive() {
		return isProgramActive;
	}

	public void setIsProgramActive(boolean isProgramActive) {
		this.isProgramActive = isProgramActive;
	}
	
	public Bmi_bmr getBmi_bmr() {
		return bmi_bmr;
	}

	public void setBmi_bmr(Bmi_bmr bmi_bmr) {
		this.bmi_bmr = bmi_bmr;
	}

	public Object getTargetWeight() {
		return targetWeight;
	}

	public void setTargetWeight(Object targetWeight) {
		this.targetWeight = targetWeight;
	}

	
	
	public TraineeProfileImage getTraineeProfileImg() {
		return traineeProfileImg;
	}

	public void setTraineeProfileImg(TraineeProfileImage traineeProfileImg) {
		this.traineeProfileImg = traineeProfileImg;
	}

	public double getApp_version() {
		return app_version;
	}

	public void setApp_version(double app_version) {
		this.app_version = app_version;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean getAddress_submission() {
		return address_submission;
	}

	public void setAddress_submission(boolean address_submission) {
		this.address_submission = address_submission;
	}

	public boolean getProfile_submission() {
		return profile_submission;
	}

	public void setProfile_submission(boolean profile_submission) {
		this.profile_submission = profile_submission;
	}

	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	
	
	public String getProgram_id() {
		return program_id;
	}

	public void setProgram_id(String program_id) {
		this.program_id = program_id;
	}

	public Date getProgram_startdate() {
		return program_startdate;
	}

	public void setProgram_startdate(Date program_startdate) {
		this.program_startdate = program_startdate;
	}

	

	public String getTrainee_id() {
		return trainee_id;
	}

	public void setTrainee_id(String trainee_id) {
		this.trainee_id = trainee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getTrainee_profile_staus() {
		return trainee_profile_staus;
	}

	public void setTrainee_profile_staus(String trainee_profile_staus) {
		this.trainee_profile_staus = trainee_profile_staus;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Object getCurrrent_weight() {
		return currrent_weight;
	}

	public void setCurrrent_weight(Object currrent_weight) {
		this.currrent_weight = currrent_weight;
	}

	public Object getTrainee_height() {
		return trainee_height;
	}

	public void setTrainee_height(Object trainee_height) {
		this.trainee_height = trainee_height;
	}

	public String getActivity_level() {
		return activity_level;
	}

	public void setActivity_level(String activity_level) {
		this.activity_level = activity_level;
	}

	public String getPrimary_goal() {
		return primary_goal;
	}

	public void setPrimary_goal(String primary_goal) {
		this.primary_goal = primary_goal;
	}

	public Object getBest_workout_day() {
		return best_workout_day;
	}

	public void setBest_workout_day(Object best_workout_day) {
		this.best_workout_day = best_workout_day;
	}

	public Object getFood_preference() {
		return food_preference;
	}

	public void setFood_preference(Object food_preference) {
		this.food_preference = food_preference;
	}

	public Object getSmoke_alcohol_consumption() {
		return smoke_alcohol_consumption;
	}

	public void setSmoke_alcohol_consumption(Object smoke_alcohol_consumption) {
		this.smoke_alcohol_consumption = smoke_alcohol_consumption;
	}

	public String getSleep_duration() {
		return sleep_duration;
	}

	public void setSleep_duration(String sleep_duration) {
		this.sleep_duration = sleep_duration;
	}

	public String getSleep_quality() {
		return sleep_quality;
	}

	public void setSleep_quality(String sleep_quality) {
		this.sleep_quality = sleep_quality;
	}

	public Object getMedical_history() {
		return medical_history;
	}

	public void setMedical_history(Object medical_history) {
		this.medical_history = medical_history;
	}

	public Object getPrevious_workout_history() {
		return previous_workout_history;
	}

	public void setPrevious_workout_history(Object previous_workout_history) {
		this.previous_workout_history = previous_workout_history;
	}

	public String getTrainee_timezone() {
		return trainee_timezone;
	}

	public void setTrainee_timezone(String trainee_timezone) {
		this.trainee_timezone = trainee_timezone;
	}

	public List<TraineeAddress> getTrainee_address() {
		return trainee_address;
	}

	public void setTrainee_address(List<TraineeAddress> trainee_address) {
		this.trainee_address = trainee_address;
	}

	public Object getLat_logAttributes() {
		return lat_logAttributes;
	}

	public void setLat_logAttributes(Object lat_logAttributes) {
		this.lat_logAttributes = lat_logAttributes;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public Date getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}

}
