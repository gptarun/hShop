package com.hsoft.app.model;

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
@Table(name = "icd_codes")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class ICDCodes {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "icdSequence")
	@SequenceGenerator(name = "icdSequence", sequenceName = "ICD_SEQ", allocationSize = 1)
	private long icdId;
	private String diseaseCode;
	private String diseaseName;

	public long getIcdId() {
		return icdId;
	}

	public void setIcdId(long icdId) {
		this.icdId = icdId;
	}

	public String getDiseaseCode() {
		return diseaseCode;
	}

	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

}
