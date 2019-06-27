package com.hsoft.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "patient_history")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class PatientHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patientHistorySequence")
	@SequenceGenerator(name = "patientHistorySequence", sequenceName = "HISTORY_SEQ", allocationSize = 1)
	private long patientHistoryId;
	private String firstName;
	private String lastName;
	

	private String patientNumber;
	private Date admissionDate;
	private long   lastBedId;
	private long   lastWardId;
	private boolean isActive;
	private String consultingDoctor;
	private String dischargeDoctor;
	private Date dischargeDate;
	private String schemeName;
	private String schemeType;
	private String planName;
	private double discount;
	private double totalBillAmount;
	private double netPay;
	private String dischargeStatus;
	
	
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

	public long getPatientHistoryId() {
		return patientHistoryId;
	}

	public void setPatientHistoryId(long patientHistoryId) {
		this.patientHistoryId = patientHistoryId;
	}

	
	public String getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public long getLastBedId() {
		return lastBedId;
	}

	public void setLastBedId(long lastBedId) {
		this.lastBedId = lastBedId;
	}

	public long getLastWardId() {
		return lastWardId;
	}

	public void setLastWardId(long lastWardId) {
		this.lastWardId = lastWardId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getConsultingDoctor() {
		return consultingDoctor;
	}

	public void setConsultingDoctor(String consultingDoctor) {
		this.consultingDoctor = consultingDoctor;
	}

	public String getDischargeDoctor() {
		return dischargeDoctor;
	}

	public void setDischargeDoctor(String dischargeDoctor) {
		this.dischargeDoctor = dischargeDoctor;
	}

	public Date getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getSchemeType() {
		return schemeType;
	}

	public void setSchemeType(String schemeType) {
		this.schemeType = schemeType;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTotalBillAmount() {
		return totalBillAmount;
	}

	public void setTotalBillAmount(double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}

	public double getNetPay() {
		return netPay;
	}

	public void setNetPay(double netPay) {
		this.netPay = netPay;
	}

	public String getDischargeStatus() {
		return dischargeStatus;
	}

	public void setDischargeStatus(String dischargeStatus) {
		this.dischargeStatus = dischargeStatus;
	}

}
