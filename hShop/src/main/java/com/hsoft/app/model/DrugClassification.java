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
@Table(name = "drugClassification")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class DrugClassification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drugCSequence")
	@SequenceGenerator(name = "drugCSequence", sequenceName = "DRUG_C_SEQ", allocationSize = 1)
	private long drugCId;
	
	private String drugCName;

	public long getDrugCId() {
		return drugCId;
	}

	public void setDrugCId(long drugCId) {
		this.drugCId = drugCId;
	}

	public String getDrugCName() {
		return drugCName;
	}

	public void setDrugCName(String drugCName) {
		this.drugCName = drugCName;
	}
	
	

}
