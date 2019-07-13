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
@Table(name = "surgery")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Surgery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "surgerySequence")
	@SequenceGenerator(name = "surgerySequence", sequenceName = "SURGERY_SEQ", allocationSize = 1)
	private long surgeryId;
	
	private String surgeryName;

	public long getSurgeryId() {
		return surgeryId;
	}

	public void setSurgeryId(long surgeryId) {
		this.surgeryId = surgeryId;
	}

	public String getSurgeryName() {
		return surgeryName;
	}

	public void setSurgeryName(String surgeryName) {
		this.surgeryName = surgeryName;
	}
	
	

}
