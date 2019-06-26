package com.hsoft.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "patient_scheme_details")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class PatientSchemeDet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patientSchemeDetSequence")
	@SequenceGenerator(name = "patientSchemeDetSequence", sequenceName = "PATIENT_SCHEME_DET_SEQ", allocationSize = 1)
	@Column(name = "patient_scheme_det_id", updatable = false, nullable = false)
	private long patientSchemeDetId;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name = "scheme_details_id")
	private SchemeDetails schemeDetails;

	public long getPatientSchemeDetId() {
		return patientSchemeDetId;
	}

	public void setPatientSchemeDetId(long patientSchemeDetId) {
		this.patientSchemeDetId = patientSchemeDetId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public SchemeDetails getSchemeDetails() {
		return schemeDetails;
	}

	public void setSchemeDetails(SchemeDetails schemeDetails) {
		this.schemeDetails = schemeDetails;
	}

}
