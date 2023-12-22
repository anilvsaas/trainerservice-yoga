package com.yoga.trainerserviceyoga.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.yoga.trainerserviceyoga.childmodel.AdminComment;
import com.yoga.trainerserviceyoga.childmodel.AsanaVideo;
import com.yoga.trainerserviceyoga.childmodel.Comment;
import com.yoga.trainerserviceyoga.childmodel.CommonReferenceModel;
import com.yoga.trainerserviceyoga.childmodel.Yoga_Set;

@Document(collection = "yoga_asanas")
public class AsanaModel {
	@Id
	private String asanaId;
	private String trainerId;
	private AsanaVideo asanaVideo;
	private String asanaTitle;
	private CommonReferenceModel asanaType;
	private List<Yoga_Set> sets;
	private String adoptedName;
	private List<CommonReferenceModel> targetMuscle;
	private CommonReferenceModel difficultyLevel;
	private List<CommonReferenceModel> asanaGoal;
	private CommonReferenceModel therapeutic;
	private String benifitsOfAsana;
	private String precautions;
	private List<CommonReferenceModel> instructions;
	private boolean isPublic;
	private Date isPublicDate;
	private Date creationDate;
	private Date lastUpdatedDate;
	private String asanaPercentage;
	private String asanaStatus;
	private String asanaRefId;
	private String adminStatus;
	private List<AdminComment> approvalComments;
	private boolean isChangeAffects;
	private List<Comment> asanaComments;
	

	public List<Comment> getAsanaComments() {
		return asanaComments;
	}

	public void setAsanaComments(List<Comment> asanaComments) {
		this.asanaComments = asanaComments;
	}

	public String getAsanaRefId() {
		return asanaRefId;
	}

	public void setAsanaRefId(String asanaRefId) {
		this.asanaRefId = asanaRefId;
	}

	public String getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}

	public List<AdminComment> getApprovalComments() {
		return approvalComments;
	}

	public void setApprovalComments(List<AdminComment> approvalComments) {
		this.approvalComments = approvalComments;
	}

	public boolean getIsChangeAffects() {
		return isChangeAffects;
	}

	public void setiSChangeAffects(boolean isChangeAffects) {
		this.isChangeAffects = isChangeAffects;
	}

	public String getAsanaPercentage() {
		return asanaPercentage;
	}

	public void setAsanaPercentage(String asanaPercentage) {
		this.asanaPercentage = asanaPercentage;
	}

	public String getAsanaStatus() {
		return asanaStatus;
	}

	public void setAsanaStatus(String asanaStatus) {
		this.asanaStatus = asanaStatus;
	}

	public List<CommonReferenceModel> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<CommonReferenceModel> instructions) {
		this.instructions = instructions;
	}

	public List<Yoga_Set> getSets() {
		return sets;
	}

	public void setSets(List<Yoga_Set> sets) {
		this.sets = sets;
	}

	public boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public Date getIsPublicDate() {
		return isPublicDate;
	}

	public void setIsPublicDate(Date isPublicDate) {
		this.isPublicDate = isPublicDate;
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

	public String getAsanaId() {
		return asanaId;
	}

	public void setAsanaId(String asanaId) {
		this.asanaId = asanaId;
	}

	public String getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	public AsanaVideo getAsanaVideo() {
		return asanaVideo;
	}

	public void setAsanaVideo(AsanaVideo asanaVideo) {
		this.asanaVideo = asanaVideo;
	}

	public String getAsanaTitle() {
		return asanaTitle;
	}

	public void setAsanaTitle(String asanaTitle) {
		this.asanaTitle = asanaTitle;
	}

	public CommonReferenceModel getAsanaType() {
		return asanaType;
	}

	public void setAsanaType(CommonReferenceModel asanaType) {
		this.asanaType = asanaType;
	}

	public String getAdoptedName() {
		return adoptedName;
	}

	public void setAdoptedName(String adoptedName) {
		this.adoptedName = adoptedName;
	}

	public List<CommonReferenceModel> getTargetMuscle() {
		return targetMuscle;
	}

	public void setTargetMuscle(List<CommonReferenceModel> targetMuscle) {
		this.targetMuscle = targetMuscle;
	}

	public CommonReferenceModel getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(CommonReferenceModel difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public List<CommonReferenceModel> getAsanaGoal() {
		return asanaGoal;
	}

	public void setAsanaGoal(List<CommonReferenceModel> asanaGoal) {
		this.asanaGoal = asanaGoal;
	}

	public CommonReferenceModel getTherapeutic() {
		return therapeutic;
	}

	public void setTherapeutic(CommonReferenceModel therapeutic) {
		this.therapeutic = therapeutic;
	}

	public String getBenifitsOfAsana() {
		return benifitsOfAsana;
	}

	public void setBenifitsOfAsana(String benifitsOfAsana) {
		this.benifitsOfAsana = benifitsOfAsana;
	}

	public String getPrecautions() {
		return precautions;
	}

	public void setPrecautions(String precautions) {
		this.precautions = precautions;
	}

}
