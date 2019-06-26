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
@Table(name = "Radiology")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)


public class Radiology {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "radiologySequence")
	@SequenceGenerator(name = "radiologySequence", sequenceName = "RADIOLOGY_SEQ", allocationSize = 1)
	private long serviceId;
	
	private String serviceName;
	private String examinationRequired;
	private String comment;
	
	public long getServiceId() {
		return serviceId;
	}
	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getExaminationRequired() {
		return examinationRequired;
	}
	public void setExaminationRequired(String examinationRequired) {
		this.examinationRequired = examinationRequired;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
