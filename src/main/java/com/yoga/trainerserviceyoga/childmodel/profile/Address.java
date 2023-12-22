package com.yoga.trainerserviceyoga.childmodel.profile;

public class Address {
	private String address;
	private String city;
	private String state;
	private String country;
	private String pincode;
	private boolean isPrimary;
	private LatLongAttributes latLongAttributes;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public boolean getIsPrimary() {
		return isPrimary;
	}
	public void setIsPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
	public LatLongAttributes getLatLongAttributes() {
		return latLongAttributes;
	}
	public void setLatLongAttributes(LatLongAttributes latLongAttributes) {
		this.latLongAttributes = latLongAttributes;
	}
	
}
