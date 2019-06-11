package com.hsoft.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "role_module", uniqueConstraints = { @UniqueConstraint(columnNames = "ROLE_MODULE_ID") })
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class RoleModuleTab {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleModuleSequence")
	@SequenceGenerator(name = "roleModuleSequence", sequenceName = "ROLE_MODULE_SEQ", allocationSize = 1)
	@Column(name = "ROLE_MODULE_ID")
	private long roleModuleId;

	@Column(name = "role_id")
	private long roleId;

	@Column(name = "module_id")
	private long moduleId;

	public RoleModuleTab() {
		super();
	}

	public RoleModuleTab(long roleId, long moduleId) {
		super();
		this.roleId = roleId;
		this.moduleId = moduleId;
	}

	public long getRoleModuleId() {
		return roleModuleId;
	}

	public void setRoleModuleId(long roleModuleId) {
		this.roleModuleId = roleModuleId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getModuleId() {
		return moduleId;
	}

	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}

}
