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

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PatientDischarge")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class PatientDischarge {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patientDischarge")
	@SequenceGenerator(name = "patientDischarge", sequenceName = "DISCHARGE_SEQ", allocationSize = 1)
	private long patientDischargeId;

	private Date dischargeDate;
	private String dischargeStatus;
	private String finalDiagnosis;
	private String consultant;
	@Column(name = "is_summary_written")
	private boolean isSummaryWritten;
	@Column(name = "other_comments", length = 500)
	private String otherComments;
	private String patientNumber;

	public long getPatientDischargeId() {
		return patientDischargeId;
	}

	public void setPatientDischargeId(long patientDischargeId) {
		this.patientDischargeId = patientDischargeId;
	}

	public Date getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public String getDischargeStatus() {
		return dischargeStatus;
	}

	public void setDischargeStatus(String dischargeStatus) {
		this.dischargeStatus = dischargeStatus;
	}

	public String getFinalDiagnosis() {
		return finalDiagnosis;
	}

	public void setFinalDiagnosis(String finalDiagnosis) {
		this.finalDiagnosis = finalDiagnosis;
	}

	public String getConsultant() {
		return consultant;
	}

	public void setConsultant(String consultant) {
		this.consultant = consultant;
	}

	public boolean isSummaryWritten() {
		return isSummaryWritten;
	}

	public void setSummaryWritten(boolean isSummaryWritten) {
		this.isSummaryWritten = isSummaryWritten;
	}

	public String getOtherComments() {
		return otherComments;
	}

	public void setOtherComments(String otherComments) {
		this.otherComments = otherComments;
	}

	public String getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}

}
