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
@Table(name = "religion")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Religion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "religionSequence")
	@SequenceGenerator(name = "religionSequence", sequenceName = "RELIGION_SEQ", allocationSize = 1)
	private long religionId;
	
	private String religionName;

	public long getReligionId() {
		return religionId;
	}

	public void setReligionId(long religionId) {
		this.religionId = religionId;
	}

	public String getReligionName() {
		return religionName;
	}

	public void setReligionName(String religionName) {
		this.religionName = religionName;
	}
	

}
