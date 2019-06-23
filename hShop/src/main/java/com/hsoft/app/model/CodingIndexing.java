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
@Table(name = "coding_indexing")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class CodingIndexing {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "codeIndexSequence")
	@SequenceGenerator(name = "codeIndexSequence", sequenceName = "CI_SEQ", allocationSize = 1)
	private long codeIndexId;

	private String patientNumber;
	private Date startDate;
	private Date endDate;
	@Column(name = "provisional_diagnosis", length = 1000)
	private String provisionalDiagnosis;
	@Column(name = "final_diagnosis", length = 1000)
	private String finalDiagnosis;
	private String primaryCode;
	private String secodaryCode;
	private String associatedCode;
	private String extraDiagCode;
	private String operationCode;
	private String operationCode2;
	private String resultPxCode;
	private boolean isPostMortem;

	public String getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}

	public long getCodeIndexId() {
		return codeIndexId;
	}

	public void setCodeIndexId(long codeIndexId) {
		this.codeIndexId = codeIndexId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getProvisionalDiagnosis() {
		return provisionalDiagnosis;
	}

	public void setProvisionalDiagnosis(String provisionalDiagnosis) {
		this.provisionalDiagnosis = provisionalDiagnosis;
	}

	public String getFinalDiagnosis() {
		return finalDiagnosis;
	}

	public void setFinalDiagnosis(String finalDiagnosis) {
		this.finalDiagnosis = finalDiagnosis;
	}

	public String getPrimaryCode() {
		return primaryCode;
	}

	public void setPrimaryCode(String primaryCode) {
		this.primaryCode = primaryCode;
	}

	public String getSecodaryCode() {
		return secodaryCode;
	}

	public void setSecodaryCode(String secodaryCode) {
		this.secodaryCode = secodaryCode;
	}

	public String getAssociatedCode() {
		return associatedCode;
	}

	public void setAssociatedCode(String associatedCode) {
		this.associatedCode = associatedCode;
	}

	public String getExtraDiagCode() {
		return extraDiagCode;
	}

	public void setExtraDiagCode(String extraDiagCode) {
		this.extraDiagCode = extraDiagCode;
	}

	public String getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}

	public String getOperationCode2() {
		return operationCode2;
	}

	public void setOperationCode2(String operationCode2) {
		this.operationCode2 = operationCode2;
	}

	public String getResultPxCode() {
		return resultPxCode;
	}

	public void setResultPxCode(String resultPxCode) {
		this.resultPxCode = resultPxCode;
	}

	public boolean isPostMortem() {
		return isPostMortem;
	}

	public void setPostMortem(boolean isPostMortem) {
		this.isPostMortem = isPostMortem;
	}

}
