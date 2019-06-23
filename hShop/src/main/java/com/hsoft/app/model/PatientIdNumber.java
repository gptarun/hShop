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
@Table(name = "patient_id_number")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class PatientIdNumber {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patientIdNumSequence")
	@SequenceGenerator(name = "patientIdNumSequence", sequenceName = "PidNum_SEQ", allocationSize = 1)
	private long pIdNum;

	private long id;

	private String name;

	public PatientIdNumber() {
		super();
	}

	public PatientIdNumber(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public long getpIdNum() {
		return pIdNum;
	}

	public void setpIdNum(long pIdNum) {
		this.pIdNum = pIdNum;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
