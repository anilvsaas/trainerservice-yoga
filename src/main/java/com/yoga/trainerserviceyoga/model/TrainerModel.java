package com.yoga.trainerserviceyoga.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.List;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yoga.trainerserviceyoga.childmodel.AdminComment;
import com.yoga.trainerserviceyoga.childmodel.CommonReferenceModel;
import com.yoga.trainerserviceyoga.childmodel.Nutritionist;
import com.yoga.trainerserviceyoga.childmodel.profile.Achievement;
import com.yoga.trainerserviceyoga.childmodel.profile.Address;
import com.yoga.trainerserviceyoga.childmodel.profile.Category;
import com.yoga.trainerserviceyoga.childmodel.profile.Certification;
import com.yoga.trainerserviceyoga.childmodel.profile.ProfileImage;
import com.yoga.trainerserviceyoga.childmodel.profile.ProfileIntroVideo;
import com.yoga.trainerserviceyoga.childmodel.profile.ServiceOffered;
import com.yoga.trainerserviceyoga.childmodel.profile.SocialAccount;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Document(collection = "yoga_trainers")
public class TrainerModel implements Persistable<String> {
	private String trainerId;
	@NotNull(message = "Trainer username required")
	@Email(message = "Please provide valid email")
	private String trainerUserName;
	private String profileStatus;
	private String registraionType;
	private String adminStatus;
	@CreatedDate
	private Date creationDate;
	@NotBlank(message = "Trainer gender is required")
	private String gender;
	@NotNull(message = "Category is required")
	private List<Category> category;
	@NotBlank(message = "Trainer first name is required")
	private String firstName;
	@NotBlank(message = "Trainer last name is required")
	private String lastName;
	private String trainerTimezone;
	@NotNull(message = "Address is required")
	private List<Address> address;
	private List<SocialAccount> trainerSocialAccounts;
	@NotNull(message = "Please provide training since")
	private CommonReferenceModel trainingSince;
	@NotNull(message = "Please provide services offered")
	private List<ServiceOffered> serviceOffered;
	private List<Certification> certification;
	private Nutritionist isNutritionist;
	private String about;
	@NotNull(message = "Please provide achievements")
	private List<Achievement> achievements;
	@NotNull(message = "Please provide profile image details")
	private ProfileImage profileImage;
	@NotNull(message = "Please provide profile video details")
	private ProfileIntroVideo profileIntroVideo;
	@LastModifiedDate
	private Date lastUpdatedDate;
	private boolean isNew;
	private String phoneNumber;
	private boolean isBusinessDetailsSubmitted;
	private List<AdminComment> approvalComments;
	private Date dateOfBirth;
	private boolean isPriority;
	private int serviceFee;
	private List<CommonReferenceModel> specializedIn;
	public List<CommonReferenceModel> getSpecializedIn() {
		return specializedIn;
	}

	public void setSpecializedIn(List<CommonReferenceModel> specializedIn) {
		this.specializedIn = specializedIn;
	}

	public int getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(int serviceFee) {
		this.serviceFee = serviceFee;
	}

	public boolean getIsPriority() {
		return isPriority;
	}

	public void setIsPriority(boolean isPriority) {
		this.isPriority = isPriority;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<AdminComment> getApprovalComments() {
		return approvalComments;
	}

	public void setApprovalComments(List<AdminComment> approvalComments) {
		this.approvalComments = approvalComments;
	}

	public void setBusinessDetailsSubmitted(boolean isBusinessDetailsSubmitted) {
		this.isBusinessDetailsSubmitted = isBusinessDetailsSubmitted;
	}

	public boolean getIsBusinessDetailsSubmitted() {
		return isBusinessDetailsSubmitted;
	}

	public void setIsBusinessDetailsSubmitted(boolean isBusinessDetailsSubmitted) {
		this.isBusinessDetailsSubmitted = isBusinessDetailsSubmitted;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerUserName() {
		return trainerUserName;
	}

	public void setTrainerUserName(String trainerUserName) {
		this.trainerUserName = trainerUserName;
	}

	public String getProfileStatus() {
		return profileStatus;
	}

	public void setProfileStatus(String profileStatus) {
		this.profileStatus = profileStatus;
	}

	public String getRegistraionType() {
		return registraionType;
	}

	public void setRegistraionType(String registraionType) {
		this.registraionType = registraionType;
	}

	public String getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTrainerTimezone() {
		return trainerTimezone;
	}

	public void setTrainerTimezone(String trainerTimezone) {
		this.trainerTimezone = trainerTimezone;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<SocialAccount> getTrainerSocialAccounts() {
		return trainerSocialAccounts;
	}

	public void setTrainerSocialAccounts(List<SocialAccount> trainerSocialAccounts) {
		this.trainerSocialAccounts = trainerSocialAccounts;
	}

	public CommonReferenceModel getTrainingSince() {
		return trainingSince;
	}

	public void setTrainingSince(CommonReferenceModel trainingSince) {
		this.trainingSince = trainingSince;
	}

	public List<ServiceOffered> getServiceOffered() {
		return serviceOffered;
	}

	public void setServiceOffered(List<ServiceOffered> serviceOffered) {
		this.serviceOffered = serviceOffered;
	}

	public List<Certification> getCertification() {
		return certification;
	}

	public void setCertification(List<Certification> certification) {
		this.certification = certification;
	}

	public Nutritionist getIsNutritionist() {
		return isNutritionist;
	}

	public void setIsNutritionist(Nutritionist isNutritionist) {
		this.isNutritionist = isNutritionist;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<Achievement> getAchievements() {
		return achievements;
	}

	public void setAchievements(List<Achievement> achievements) {
		this.achievements = achievements;
	}

	public ProfileImage getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(ProfileImage profileImage) {
		this.profileImage = profileImage;
	}

	public ProfileIntroVideo getProfileIntroVideo() {
		return profileIntroVideo;
	}

	public void setProfileIntroVideo(ProfileIntroVideo profileIntroVideo) {
		this.profileIntroVideo = profileIntroVideo;
	}

//	public Date getLastUpdatedDate() {
//		return lastUpdatedDate;
//	}
//	public void setLastUpdatedDate(Date lastUpdatedDate) {
//		this.lastUpdatedDate = lastUpdatedDate;
//	}
	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
