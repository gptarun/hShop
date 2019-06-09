package com.hsoft.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "module")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moduleSequence")
	@SequenceGenerator(name = "moduleSequence", sequenceName = "MODULE_SEQ", allocationSize = 1)
	private long moduleId;
	
	@Column(name = "module_name")
	private String moduleName;
	
	@ManyToOne(optional = false)
    @JoinColumn(name="PARENT_MODULE_ID")
    private ParentModule parentModule;

	public long getModuleId() {
		return moduleId;
	}

	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public ParentModule getParentModule() {
		return parentModule;
	}

	public void setParentModule(ParentModule parentModule) {
		this.parentModule = parentModule;
	}
	
}
