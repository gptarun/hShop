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
@Table(name = "coding_indexing")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class CodingIndexing {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "codeIndexSequence")
	@SequenceGenerator(name = "codeIndexSequence", sequenceName = "CI_SEQ", allocationSize = 1)
	private long codeIndexId;

	public long getCodeIndexId() {
		return codeIndexId;
	}

	public void setCodeIndexId(long codeIndexId) {
		this.codeIndexId = codeIndexId;
	}

}
