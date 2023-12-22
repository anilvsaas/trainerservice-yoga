package com.yoga.trainerserviceyoga.childmodel;

import com.yoga.trainerserviceyoga.childmodel.profile.TraineeProfileImage;

public class Participant {
	private String trainee_id;
	private String program_id;
	private String first_name;
	private String last_name;
	private String mobile_no;
	private String username;
	private String program_name;
	private TraineeProfileImage traineeProfileImg;
	private String BMI;
	private String RoomStatus;
	private String RoomType;
	private String RoomSid;
	private String RoomName;
	private String ParticipantDuration;
	private String ParticipantStatus;
	private String ParticipantIdentity;
	private String SequenceNumber;
	private String ParticipantSid;
	private String AccountSid;
	private String startTime;
	private String endTime;
	private int age;
	private Object currrent_weight;
	private Object trainee_height;

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
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTrainee_id() {
		return trainee_id;
	}

	public void setTrainee_id(String trainee_id) {
		this.trainee_id = trainee_id;
	}

	public String getProgram_id() {
		return program_id;
	}

	public void setProgram_id(String program_id) {
		this.program_id = program_id;
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

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProgram_name() {
		return program_name;
	}

	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}

	public TraineeProfileImage getTraineeProfileImg() {
		return traineeProfileImg;
	}

	public void setTraineeProfileImg(TraineeProfileImage traineeProfileImg) {
		this.traineeProfileImg = traineeProfileImg;
	}

	public String getBMI() {
		return BMI;
	}

	public void setBMI(String bMI) {
		BMI = bMI;
	}

	public String getRoomStatus() {
		return RoomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		RoomStatus = roomStatus;
	}

	public String getRoomType() {
		return RoomType;
	}

	public void setRoomType(String roomType) {
		RoomType = roomType;
	}

	public String getRoomSid() {
		return RoomSid;
	}

	public void setRoomSid(String roomSid) {
		RoomSid = roomSid;
	}

	public String getRoomName() {
		return RoomName;
	}

	public void setRoomName(String roomName) {
		RoomName = roomName;
	}

	public String getParticipantDuration() {
		return ParticipantDuration;
	}

	public void setParticipantDuration(String participantDuration) {
		ParticipantDuration = participantDuration;
	}

	public String getParticipantStatus() {
		return ParticipantStatus;
	}

	public void setParticipantStatus(String participantStatus) {
		ParticipantStatus = participantStatus;
	}

	public String getParticipantIdentity() {
		return ParticipantIdentity;
	}

	public void setParticipantIdentity(String participantIdentity) {
		ParticipantIdentity = participantIdentity;
	}

	public String getSequenceNumber() {
		return SequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		SequenceNumber = sequenceNumber;
	}
	
	public String getParticipantSid() {
		return ParticipantSid;
	}

	public void setParticipantSid(String participantSid) {
		ParticipantSid = participantSid;
	}

	public String getAccountSid() {
		return AccountSid;
	}

	public void setAccountSid(String accountSid) {
		AccountSid = accountSid;
	}

}
