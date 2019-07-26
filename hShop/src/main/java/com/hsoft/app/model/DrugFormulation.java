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
@Table(name = "drugFormulation")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class DrugFormulation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drugFSequence")
	@SequenceGenerator(name = "drugFSequence", sequenceName = "DRUG_F_SEQ", allocationSize = 1)
	private long drugFId;
	
	private String drugFName;

	public long getDrugFId() {
		return drugFId;
	}

	public void setDrugFId(long drugFId) {
		this.drugFId = drugFId;
	}

	public String getDrugFName() {
		return drugFName;
	}

	public void setDrugFName(String drugFName) {
		this.drugFName = drugFName;
	}
	
	
	

}
