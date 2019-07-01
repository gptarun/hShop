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
@Table(name = "clerking_desk")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class ClerkingDesk {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clerkingDeskSequence")
	@SequenceGenerator(name = "clerkingDeskSequence", sequenceName = "CLERKING_DESK_SEQ", allocationSize = 1)
	private long clerkingDeskId;
	
	private String patientNumber;
    private String assignedDoctor;
	private String presentComplaint;
	private String historyPresentComplaint;
	private String investigationAndFindings;
	private String provisionalDiagnosis;
	private String icdDiseases;
	
	public long getClerkingDeskId() {
		return clerkingDeskId;
	}
	public void setClerkingDeskId(long clerkingDeskId) {
		this.clerkingDeskId = clerkingDeskId;
	}
	public String getPatientNumber() {
		return patientNumber;
	}
	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}
	public String getAssignedDoctor() {
		return assignedDoctor;
	}
	public void setAssignedDoctor(String assignedDoctor) {
		this.assignedDoctor = assignedDoctor;
	}
	public String getPresentComplaint() {
		return presentComplaint;
	}
	public void setPresentComplaint(String presentComplaint) {
		this.presentComplaint = presentComplaint;
	}
	public String getHistoryPresentComplaint() {
		return historyPresentComplaint;
	}
	public void setHistoryPresentComplaint(String historyPresentComplaint) {
		this.historyPresentComplaint = historyPresentComplaint;
	}
	public String getInvestigationAndFindings() {
		return investigationAndFindings;
	}
	public void setInvestigationAndFindings(String investigationAndFindings) {
		this.investigationAndFindings = investigationAndFindings;
	}
	public String getProvisionalDiagnosis() {
		return provisionalDiagnosis;
	}
	public void setProvisionalDiagnosis(String provisionalDiagnosis) {
		this.provisionalDiagnosis = provisionalDiagnosis;
	}
	public String getIcdDiseases() {
		return icdDiseases;
	}
	public void setIcdDiseases(String icdDiseases) {
		this.icdDiseases = icdDiseases;
	}
	
	
	
	
}
