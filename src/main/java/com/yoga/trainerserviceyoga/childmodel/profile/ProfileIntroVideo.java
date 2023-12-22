package com.yoga.trainerserviceyoga.childmodel.profile;

import java.util.Date;

public class ProfileIntroVideo {
	private String profileVideoName;
	private String videoThumbnailPath;
	private String videosourceUrl;
	private String videoDestinationCheck;
	private String videoMp4Destination;
	private boolean videoVerfied;
	private Date videouploadedOn;

	public String getProfileVideoName() {
		return profileVideoName;
	}

	public void setProfileVideoName(String profileVideoName) {
		this.profileVideoName = profileVideoName;
	}

	public String getVideoThumbnailPath() {
		return videoThumbnailPath;
	}

	public void setVideoThumbnailPath(String videoThumbnailPath) {
		this.videoThumbnailPath = videoThumbnailPath;
	}

	public String getVideosourceUrl() {
		return videosourceUrl;
	}

	public void setVideosourceUrl(String videosourceUrl) {
		this.videosourceUrl = videosourceUrl;
	}

	public String getVideoDestinationCheck() {
		return videoDestinationCheck;
	}

	public void setVideoDestinationCheck(String videoDestinationCheck) {
		this.videoDestinationCheck = videoDestinationCheck;
	}

	public String getVideoMp4Destination() {
		return videoMp4Destination;
	}

	public void setVideoMp4Destination(String videoMp4Destination) {
		this.videoMp4Destination = videoMp4Destination;
	}

	public boolean isVideoVerfied() {
		return videoVerfied;
	}

	public void setVideoVerfied(boolean videoVerfied) {
		this.videoVerfied = videoVerfied;
	}

	public Date getVideouploadedOn() {
		return videouploadedOn;
	}

	public void setVideouploadedOn(Date videouploadedOn) {
		this.videouploadedOn = videouploadedOn;
	}

}
