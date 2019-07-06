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
@Table(name = "globalSettings")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)

public class GlobalSettings {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "globalSettingsSequence")
	@SequenceGenerator(name = "globalSettingsSequence", sequenceName = "GLOBAL_SETTINGS_SEQ", allocationSize = 1)
	private long globalSettingId;
	
	private boolean departmentDeposit;
	private boolean clerking;
	private boolean drugReorder;
	private boolean registrationValidation;
	private boolean drugStockManagement;
	private boolean standAlonePharmacy;
	
	private String locationName;
	
	@Column(name = "logo", length = 200000)
	private String logo;
	
	private String header;
	private String footer;
	
	
	public long getGlobalSettingId() {
		return globalSettingId;
	}
	public void setGlobalSettingId(long globalSettingId) {
		this.globalSettingId = globalSettingId;
	}
	public boolean isDepartmentDeposit() {
		return departmentDeposit;
	}
	public void setDepartmentDeposit(boolean departmentDeposit) {
		this.departmentDeposit = departmentDeposit;
	}
	public boolean isClerking() {
		return clerking;
	}
	public void setClerking(boolean clerking) {
		this.clerking = clerking;
	}
	public boolean isDrugReorder() {
		return drugReorder;
	}
	public void setDrugReorder(boolean drugReorder) {
		this.drugReorder = drugReorder;
	}
	public boolean isRegistrationValidation() {
		return registrationValidation;
	}
	public void setRegistrationValidation(boolean registrationValidation) {
		this.registrationValidation = registrationValidation;
	}
	public boolean isDrugStockManagement() {
		return drugStockManagement;
	}
	public void setDrugStockManagement(boolean drugStockManagement) {
		this.drugStockManagement = drugStockManagement;
	}
	public boolean isStandAlonePharmacy() {
		return standAlonePharmacy;
	}
	public void setStandAlonePharmacy(boolean standAlonePharmacy) {
		this.standAlonePharmacy = standAlonePharmacy;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getFooter() {
		return footer;
	}
	public void setFooter(String footer) {
		this.footer = footer;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	

}
