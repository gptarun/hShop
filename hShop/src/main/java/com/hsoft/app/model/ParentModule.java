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
@Table(name = "parent_module")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class ParentModule {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pmSequence")
	@SequenceGenerator(name = "pmSequence", sequenceName = "PM_SEQ", allocationSize = 1)
	private long parentModuleId;
	
	@Column(name = "module_name")
	private String parentModuleName;

	public long getParentModuleId() {
		return parentModuleId;
	}

	public void setParentModuleId(long parentModuleId) {
		this.parentModuleId = parentModuleId;
	}

	public String getParentModuleName() {
		return parentModuleName;
	}

	public void setParentModuleName(String parentModuleName) {
		this.parentModuleName = parentModuleName;
	}
	
}
