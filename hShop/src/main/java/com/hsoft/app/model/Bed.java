package com.hsoft.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "bed")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Bed {
	@Id
	@Column(name = "bed_id", updatable = false, nullable = false)
	private long bedId;
	private boolean isVaccant;

	public Bed() {
		super();
	}

	public Bed(long bedId, boolean isVaccant) {
		super();
		this.bedId = bedId;
		this.isVaccant = isVaccant;
	}

	public long getBedId() {
		return bedId;
	}

	public void setBedId(long bedId) {
		this.bedId = bedId;
	}

	public boolean isVaccant() {
		return isVaccant;
	}

	public void setVaccant(boolean isVaccant) {
		this.isVaccant = isVaccant;
	}

}
