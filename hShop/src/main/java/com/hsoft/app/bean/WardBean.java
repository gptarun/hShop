package com.hsoft.app.bean;

import java.util.List;

public class WardBean {

	private long wardBedId;
	private long wardId;
	private List<Long> bedId;
	private long assignedPatientId;

	public long getWardBedId() {
		return wardBedId;
	}

	public void setWardBedId(long wardBedId) {
		this.wardBedId = wardBedId;
	}

	public long getWardId() {
		return wardId;
	}

	public void setWardId(long wardId) {
		this.wardId = wardId;
	}

	public List<Long> getBedId() {
		return bedId;
	}

	public void setBedId(List<Long> bedId) {
		this.bedId = bedId;
	}

	public long getAssignedPatientId() {
		return assignedPatientId;
	}

	public void setAssignedPatientId(long assignedPatientId) {
		this.assignedPatientId = assignedPatientId;
	}

}
