package com.yoga.trainerserviceyoga.childmodel;

import java.util.Date;

public class AsanaVideo {
	private String asanaVideoSource;
	private String asanaVideoName;
	private String videoThumbnailPath;
	private String videoSourceUrl;
	private boolean videoDestinationCheck;
	private String videoMp4Destination;
	private String videoVerfied;
	private Date videoUploadedOn;
	private String youtubeUrl;
	
	
	
	public String getAsanaVideoSource() {
		return asanaVideoSource;
	}
	public void setAsanaVideoSource(String asanaVideoSource) {
		this.asanaVideoSource = asanaVideoSource;
	}
	public String getAsanavideoName() {
		return asanaVideoName;
	}
	public void setAsanavideoName(String asanaVideoName) {
		this.asanaVideoName = asanaVideoName;
	}
	public String getVideoThumbnailPath() {
		return videoThumbnailPath;
	}
	public void setVideoThumbnailPath(String videoThumbnailPath) {
		this.videoThumbnailPath = videoThumbnailPath;
	}
	public String getVideoSourceUrl() {
		return videoSourceUrl;
	}
	public void setVideoSourceUrl(String videoSourceUrl) {
		this.videoSourceUrl = videoSourceUrl;
	}
	public boolean isVideoDestinationCheck() {
		return videoDestinationCheck;
	}
	public void setVideoDestinationCheck(boolean videoDestinationCheck) {
		this.videoDestinationCheck = videoDestinationCheck;
	}
	public String getVideoMp4Destination() {
		return videoMp4Destination;
	}
	public void setVideoMp4Destination(String videoMp4Destination) {
		this.videoMp4Destination = videoMp4Destination;
	}
	public String getVideoVerfied() {
		return videoVerfied;
	}
	public void setVideoVerfied(String videoVerfied) {
		this.videoVerfied = videoVerfied;
	}
	public Date getVideoUploadedOn() {
		return videoUploadedOn;
	}
	public void setVideoUploadedOn(Date videoUploadedOn) {
		this.videoUploadedOn = videoUploadedOn;
	}
	public String getYoutubeUrl() {
		return youtubeUrl;
	}
	public void setYoutubeUrl(String youtubeUrl) {
		this.youtubeUrl = youtubeUrl;
	}
}
