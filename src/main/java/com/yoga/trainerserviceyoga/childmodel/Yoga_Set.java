package com.yoga.trainerserviceyoga.childmodel;

import com.yoga.trainerserviceyoga.childmodel.SetValue;

public class Yoga_Set {
	private int setNo;
	private SetValue reputationValue;
	private SetValue breathValue;
	private SetValue minutesPeriod;
	private SetValue secondsPeriod;
	private String   heartrate;
	public int getSetNo() {
		return setNo;
	}
	public void setSetNo(int setNo) {
		this.setNo = setNo;
	}
	public SetValue getReputationValue() {
		return reputationValue;
	}
	public void setReputationValue(SetValue reputationValue) {
		this.reputationValue = reputationValue;
	}
	public SetValue getBreathValue() {
		return breathValue;
	}
	public void setBreathValue(SetValue breathValue) {
		this.breathValue = breathValue;
	}
	public SetValue getMinutesPeriod() {
		return minutesPeriod;
	}
	public void setMinutesPeriod(SetValue minutesPeriod) {
		this.minutesPeriod = minutesPeriod;
	}
	public SetValue getSecondsPeriod() {
		return secondsPeriod;
	}
	public void setSecondsPeriod(SetValue secondsPeriod) {
		this.secondsPeriod = secondsPeriod;
	}
	public String getHeartrate() {
		return heartrate;
	}
	public void setHeartrate(String heartrate) {
		this.heartrate = heartrate;
	}
}
