package com.randotimer;

public class TrainingParams {
	private Integer minNumber;
	private Integer maxNumber;
	private Integer changeNumberDelay; // seconds
	private Integer numSets; // repititions
	private Integer setDuration; // minutes
	private Integer waitTimeBeforeStart; // seconds
	public Integer getMinNumber() {
		return minNumber;
	}
	public void setMinNumber(Integer minNumber) {
		this.minNumber = minNumber;
	}
	public Integer getMaxNumber() {
		return maxNumber;
	}
	public void setMaxNumber(Integer maxNumber) {
		this.maxNumber = maxNumber;
	}
	public Integer getChangeNumberDelay() {
		return changeNumberDelay;
	}
	public void setChangeNumberDelay(Integer changeNumberDelay) {
		this.changeNumberDelay = changeNumberDelay;
	}
	public Integer getNumSets() {
		return numSets;
	}
	public void setNumSets(Integer numSets) {
		this.numSets = numSets;
	}
	public Integer getSetDuration() {
		return setDuration;
	}
	public void setSetDuration(Integer setDuration) {
		this.setDuration = setDuration;
	}
	public Integer getWaitTimeBeforeStart() {
		return waitTimeBeforeStart;
	}
	public void setWaitTimeBeforeStart(Integer waitTimeBeforeStart) {
		this.waitTimeBeforeStart = waitTimeBeforeStart;
	}
}
