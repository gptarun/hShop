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
@Table(name = "scheme")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class SchemeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schemeDetSequence")
	@SequenceGenerator(name = "schemeDetSequence", sequenceName = "SCHEME_DET_SEQ", allocationSize = 1)
	@Column(name = "scheme_details_id", updatable = false, nullable = false)
	private long schemeDetailsId;

	@Column(name = "scheme_name")
	private String schemeName;

	@Column(name = "scheme_plan")
	private String schemePlan;

	@Column(name = "discount")
	private String discount;

	@Column(name = "primary_provider")
	private String primaryProvider;

	@Column(name = "type_of_care")
	private String typeOfCare;

	@Column(name = "diagnose")
	private String diagnose;
	
	@Column(name = "approval_code")
	private String approvalCode;
	
	@Column(name = "approval_code_start")
	private String approvalCodeStart;
	
	@Column(name = "approval_code_end")
	private String approvalCodeEnd;

	public long getSchemeDetailsId() {
		return schemeDetailsId;
	}

	public void setSchemeDetailsId(long schemeDetailsId) {
		this.schemeDetailsId = schemeDetailsId;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getSchemePlan() {
		return schemePlan;
	}

	public void setSchemePlan(String schemePlan) {
		this.schemePlan = schemePlan;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getPrimaryProvider() {
		return primaryProvider;
	}

	public void setPrimaryProvider(String primaryProvider) {
		this.primaryProvider = primaryProvider;
	}

	public String getTypeOfCare() {
		return typeOfCare;
	}

	public void setTypeOfCare(String typeOfCare) {
		this.typeOfCare = typeOfCare;
	}

	public String getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	public String getApprovalCode() {
		return approvalCode;
	}

	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}

	public String getApprovalCodeStart() {
		return approvalCodeStart;
	}

	public void setApprovalCodeStart(String approvalCodeStart) {
		this.approvalCodeStart = approvalCodeStart;
	}

	public String getApprovalCodeEnd() {
		return approvalCodeEnd;
	}

	public void setApprovalCodeEnd(String approvalCodeEnd) {
		this.approvalCodeEnd = approvalCodeEnd;
	}
	
}
