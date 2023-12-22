package com.yoga.trainerserviceyoga.childmodel;

import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "callschedules")
public class TrainerSlot {
	@Id
	private String slotId;
	private String startTime;
	private String endTime;
	private String status;
	private List<Participant> participants;
	private String roomName;
	private String roomType;
	private String roomSid;
	private int maxParticipants;
	private String roomStatus;
	private String roomCreationTime;
	private String roomEndTime;
	private String RoomDuration;
	private int participantsBooked;
	private String callType;
	private String programId;
	private String hostStartTime;
	private String hostEndTime;
	private String hostCallDuration;
	private String hostSid;
	private String hostStatus;
	private String hostIdentity;
	private String slotType;
	private String programName;
	@Transient
	private String trainee_id;
	private CommonReferenceModel frequency;
	private CommonReferenceModel delay;
	private String trainerId;
	private String timezone;
	private Date creationDate;
	private Date lastUpdatedDate;
	private String date;
	private String startDateTime;
	private String endDateTime;
	private String title;
	private String month;
	private String category;
	private String dayName;
	private String externalCallLink;
	
	public String getExternalCallLink() {
		return externalCallLink;
	}

	public void setExternalCallLink(String externalCallLink) {
		this.externalCallLink = externalCallLink;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public CommonReferenceModel getFrequency() {
		return frequency;
	}

	public void setFrequency(CommonReferenceModel frequency) {
		this.frequency = frequency;
	}

	public CommonReferenceModel getDelay() {
		return delay;
	}

	public void setDelay(CommonReferenceModel delay) {
		this.delay = delay;
	}

	public String getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getSlotType() {
		return slotType;
	}

	public void setSlotType(String slotType) {
		this.slotType = slotType;
	}

	public String getHostStatus() {
		return hostStatus;
	}

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	public void setHostStatus(String hostStatus) {
		this.hostStatus = hostStatus;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getHostIdentity() {
		return hostIdentity;
	}

	public void setHostIdentity(String hostIdentity) {
		this.hostIdentity = hostIdentity;
	}

	public String getHostStartTime() {
		return hostStartTime;
	}

	public void setHostStartTime(String hostStartTime) {
		this.hostStartTime = hostStartTime;
	}

	public String getHostEndTime() {
		return hostEndTime;
	}

	public void setHostEndTime(String hostEndTime) {
		this.hostEndTime = hostEndTime;
	}

	public String getHostCallDuration() {
		return hostCallDuration;
	}

	public void setHostCallDuration(String hostCallDuration) {
		this.hostCallDuration = hostCallDuration;
	}

	public String getHostSid() {
		return hostSid;
	}

	public void setHostSid(String hostSid) {
		this.hostSid = hostSid;
	}

	public String getTrainee_id() {
		return trainee_id;
	}

	public void setTrainee_id(String trainee_id) {
		this.trainee_id = trainee_id;
	}

	public int getParticipantsBooked() {
		return participantsBooked;
	}

	public void setParticipantsBooked(int participantsBooked) {
		this.participantsBooked = participantsBooked;
	}

	public String getRoomDuration() {
		return RoomDuration;
	}

	public void setRoomDuration(String roomDuration) {
		RoomDuration = roomDuration;
	}

	public String getRoomCreationTime() {
		return roomCreationTime;
	}

	public void setRoomCreationTime(String roomCreationTime) {
		this.roomCreationTime = roomCreationTime;
	}

	public String getRoomEndTime() {
		return roomEndTime;
	}

	public void setRoomEndTime(String roomEndTime) {
		this.roomEndTime = roomEndTime;
	}

	public String getSlotId() {
		return slotId;
	}

	public void setSlotId(String slotId) {
		this.slotId = slotId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public String getRoomSid() {
		return roomSid;
	}

	public void setRoomSid(String roomSid) {
		this.roomSid = roomSid;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}
}
