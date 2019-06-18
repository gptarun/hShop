package com.hsoft.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ward_bed", uniqueConstraints = { @UniqueConstraint(columnNames = "WARD_BED_ID") })
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class WardBedTab {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wardBedSequence")
	@SequenceGenerator(name = "wardBedSequence", sequenceName = "WARD_BED_SEQ", allocationSize = 1)
	@Column(name = "WARD_BED_ID")
	private long wardBedId;

	@Column(name = "ward_id")
	private long wardId;

	@Column(name = "bed_id")
	private long bedId;

	@Column(name = "assigned_patient_id")
	private long assignedPatientId;
	
	@Column(name = "doctor_name")
	private String doctorName;
	
	@Column(name = "admission_date")
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

	public WardBedTab(long wardId, long bedId) {
		super();
		this.wardId = wardId;
		this.bedId = bedId;
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

	public long getBedId() {
		return bedId;
	}

	public void setBedId(long bedId) {
		this.bedId = bedId;
	}

	public long getAssignedPatientId() {
		return assignedPatientId;
	}

	public void setAssignedPatientId(long assignedPatientId) {
		this.assignedPatientId = assignedPatientId;
	}

	public WardBedTab() {
		super();
	}

}
