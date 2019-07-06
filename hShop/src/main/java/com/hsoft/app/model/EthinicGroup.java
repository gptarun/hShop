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
@Table(name = "ethinicGroup")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class EthinicGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ethinicGroupSequence")
	@SequenceGenerator(name = "ethinicGroupSequence", sequenceName = "ETHINIC_GROUP_SEQ", allocationSize = 1)
	private long ethinicGroupId;
	
	private String ethinicName;

	public long getEthinicGroupId() {
		return ethinicGroupId;
	}

	public void setEthinicGroupId(long ethinicGroupId) {
		this.ethinicGroupId = ethinicGroupId;
	}

	public String getEthinicName() {
		return ethinicName;
	}

	public void setEthinicName(String ethinicName) {
		this.ethinicName = ethinicName;
	}
	
	
	
}
