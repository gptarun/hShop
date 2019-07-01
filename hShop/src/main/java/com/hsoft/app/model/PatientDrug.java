package com.hsoft.app.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PatientDrug")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class PatientDrug {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patientDrugSequence")
	@SequenceGenerator(name = "patientDrugSequence", sequenceName = "PATIENTDRUG_SEQ", allocationSize = 1)
	private long patientDrugId;
	
	
    private String patientNumber;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "patient_drug", joinColumns = {
			@JoinColumn(name = "patient_number", referencedColumnName = "patient_number") }, inverseJoinColumns = {
					@JoinColumn(name = "generic_name", referencedColumnName = "generic_name") })
	private List<Plan> plans;
	
	public long getPatientDrugId() {
		return patientDrugId;
	}

	public void setPatientDrugId(long patientDrugId) {
		this.patientDrugId = patientDrugId;
	}

	public String getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}

	public List<Plan> getPlans() {
		return plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

	
}
