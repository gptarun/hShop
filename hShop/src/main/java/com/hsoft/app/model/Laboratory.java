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
@Table(name = "Laboratory")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)


public class Laboratory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "laboratorySequence")
	@SequenceGenerator(name = "laboratorySequence", sequenceName = "LABORATORY_SEQ", allocationSize = 1)
	private long serviceCode;
	
	private String labService;
	private String spicemen;
	private String comment;

	
	public long getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(long serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getLabService() {
		return labService;
	}
	public void setLabService(String labService) {
		this.labService = labService;
	}
	public String getSpicemen() {
		return spicemen;
	}
	public void setSpicemen(String spicemen) {
		this.spicemen = spicemen;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	

}
