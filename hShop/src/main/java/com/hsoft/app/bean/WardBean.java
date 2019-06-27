package com.hsoft.app.bean;

import java.util.Date;
import java.util.List;

public class WardBean {

	private long wardBedId;
	private long wardId;
	private List<Long> bedId;
	private String assignedPatientId;
	private String doctorName;
	private Date admissionDate;

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

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

	public String getAssignedPatientId() {
		return assignedPatientId;
	}

	public void setAssignedPatientId(String assignedPatientId) {
		this.assignedPatientId = assignedPatientId;
	}

}
