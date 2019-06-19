package com.hsoft.app.model;

import javax.persistence.Column;
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
@Table(name = "prefixSuffix")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)

public class PrefixSuffix {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prefixSuffixSequence")
	@SequenceGenerator(name = "preSufSequence", sequenceName = "PRE_SUF_SEQ", allocationSize = 1)
	private long prefixSuffixId;
	
	@Column(name = "prefixSuffix_name")
	private String prefixSuffix;
	
	@Column(name = "prefixSuffix_value")
	private String prefixSuffixValue;

	public long getPrefixSuffixId() {
		return prefixSuffixId;
	}

	public void setPrefixSuffixId(long prefixSuffixId) {
		this.prefixSuffixId = prefixSuffixId;
	}

	public String getPrefixSuffix() {
		return prefixSuffix;
	}

	public void setPrefixSuffix(String prefixSuffix) {
		this.prefixSuffix = prefixSuffix;
	}

	public String getPrefixSuffixValue() {
		return prefixSuffixValue;
	}

	public void setPrefixSuffixValue(String prefixSuffixValue) {
		this.prefixSuffixValue = prefixSuffixValue;
	}

	
	
	
	

}
