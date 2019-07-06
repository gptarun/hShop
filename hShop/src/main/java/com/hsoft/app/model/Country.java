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
@Table(name = "country")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "countrySequence")
	@SequenceGenerator(name = "countrySequence", sequenceName = "COUNTRY_SEQ", allocationSize = 1)
	private long countrtyId;
	
	private String countryName;

	public long getCountrtyId() {
		return countrtyId;
	}

	public void setCountrtyId(long countrtyId) {
		this.countrtyId = countrtyId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
}
