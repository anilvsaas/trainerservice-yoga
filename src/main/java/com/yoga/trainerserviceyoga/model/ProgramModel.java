package com.yoga.trainerserviceyoga.model;

import java.util.Date;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.yoga.trainerserviceyoga.childmodel.AdminComment;
import com.yoga.trainerserviceyoga.childmodel.CommonReferenceModel;
import com.yoga.trainerserviceyoga.childmodel.ProgramSlot;
import com.yoga.trainerserviceyoga.childmodel.profile.ProgramImage;

@Document(collection = "yoga_programs")
public class ProgramModel {
	@Id
	private String programId;
	@NotBlank(message = "Please provide program name")
	private String programName;
	@NotNull(message = "Please provide number of plans")
	private Integer plans;
	@NotNull(message = "Please provide number of weeks")
	private Integer weeks;
	private Integer programDuration;
	private double priceInRupees;
	private double priceInDollars;
	@NotBlank(message = "Please provide program descriptionl")
	private String description;
	private String trainerId;
	@NotNull(message = "Please provide program image details")
	private ProgramImage programImage;
	private String status;
	private String adminStatus;
	@NotNull(message = "Please provide start date")
	private Date startDate;
	@NotNull(message = "Please provide package type")
	private CommonReferenceModel packageType;
	@NotNull(message = "Please provide enrollment date")
	private Date enrollmentDate;
	@NotNull(message = "Please provide nutrition details")
	private CommonReferenceModel nutrition;
	private List<CommonReferenceModel> ProgramAddons;
	private Integer maxBmi;
	private List<AdminComment> approvalComments;
	private int noOfSubscriptions;
	private Date endDate;
	private Date enrollmentEndDate;
	private CommonReferenceModel programType;
	private Date createdDate;
	private Date lastUpdateOn;
	private List<String> trainingDays;
	private int numberOfSlots;
	private List<ProgramSlot> slots;
	private boolean isContentProgram;
	private boolean isOnlineProgram;
	private int numberOfPartcipants;
	private CommonReferenceModel callDuration;
	private String externalCallLink;

	public String getExternalCallLink() {
		return externalCallLink;
	}

	public void setExternalCallLink(String externalCallLink) {
		this.externalCallLink = externalCallLink;
	}

	public CommonReferenceModel getCallDuration() {
		return callDuration;
	}

	public void setCallDuration(CommonReferenceModel callDuration) {
		this.callDuration = callDuration;
	}

	public boolean getIsContentProgram() {
		return isContentProgram;
	}

	public void setIsContentProgram(boolean isContentProgram) {
		this.isContentProgram = isContentProgram;
	}

	public boolean getIsOnlineProgram() {
		return isOnlineProgram;
	}

	public void setIsOnlineProgram(boolean isOnlineProgram) {
		this.isOnlineProgram = isOnlineProgram;
	}

	public int getNumberOfPartcipants() {
		return numberOfPartcipants;
	}

	public void setNumberOfPartcipants(int numberOfPartcipants) {
		this.numberOfPartcipants = numberOfPartcipants;
	}

	public List<String> getTrainingDays() {
		return trainingDays;
	}

	public void setTrainingDays(List<String> trainingDays) {
		this.trainingDays = trainingDays;
	}

	public int getNumberOfSlots() {
		return numberOfSlots;
	}

	public void setNumberOfSlots(int numberOfSlots) {
		this.numberOfSlots = numberOfSlots;
	}

	public List<ProgramSlot> getSlots() {
		return slots;
	}

	public void setSlots(List<ProgramSlot> slots) {
		this.slots = slots;
	}

	public CommonReferenceModel getProgramType() {
		return programType;
	}

	public void setProgramType(CommonReferenceModel programType) {
		this.programType = programType;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEnrollmentEndDate() {
		return enrollmentEndDate;
	}

	public void setEnrollmentEndDate(Date enrollmentEndDate) {
		this.enrollmentEndDate = enrollmentEndDate;
	}

	public double getPriceInDollars() {
		return priceInDollars;
	}

	public void setPriceInDollars(double priceInDollars) {
		this.priceInDollars = priceInDollars;
	}

	public int getNoOfSubscriptions() {
		return noOfSubscriptions;
	}

	public void setNoOfSubscriptions(int noOfSubscriptions) {
		this.noOfSubscriptions = noOfSubscriptions;
	}

	public List<AdminComment> getApprovalComments() {
		return approvalComments;
	}

	public void setApprovalComments(List<AdminComment> approvalComments) {
		this.approvalComments = approvalComments;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public Integer getPlans() {
		return plans;
	}

	public void setPlans(Integer plans) {
		this.plans = plans;
	}

	public Integer getWeeks() {
		return weeks;
	}

	public void setWeeks(Integer weeks) {
		this.weeks = weeks;
	}

	public Integer getProgramDuration() {
		return programDuration;
	}

	public void setProgramDuration(Integer programDuration) {
		this.programDuration = programDuration;
	}

	public double getPriceInRupees() {
		return priceInRupees;
	}

	public void setPriceInRupees(double priceInRupees) {
		this.priceInRupees = priceInRupees;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdateOn() {
		return lastUpdateOn;
	}

	public void setLastUpdateOn(Date lastUpdateOn) {
		this.lastUpdateOn = lastUpdateOn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	public ProgramImage getProgramImage() {
		return programImage;
	}

	public void setProgramImage(ProgramImage programImage) {
		this.programImage = programImage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public CommonReferenceModel getPackageType() {
		return packageType;
	}

	public void setPackageType(CommonReferenceModel packageType) {
		this.packageType = packageType;
	}

	public Date getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public CommonReferenceModel getNutrition() {
		return nutrition;
	}

	public void setNutrition(CommonReferenceModel nutrition) {
		this.nutrition = nutrition;
	}

	public List<CommonReferenceModel> getProgramAddons() {
		return ProgramAddons;
	}

	public void setProgramAddons(List<CommonReferenceModel> programAddons) {
		ProgramAddons = programAddons;
	}

	public Integer getMaxBmi() {
		return maxBmi;
	}

	public void setMaxBmi(Integer maxBmi) {
		this.maxBmi = maxBmi;
	}

}
