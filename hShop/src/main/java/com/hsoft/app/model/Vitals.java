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
@Table(name = "vitals")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)


public class Vitals {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vitalsSequence")
	@SequenceGenerator(name = "vitalsSequence", sequenceName = "VITALS_SEQ", allocationSize = 1)
	private long vitalsId;
	
	private String patientNumber;
	
	private String weight;
	private String height;
	private String bodyMassIndex;
	private String temperature;
	private String respiratoryRate;
	private String pulseRate;
	private String randomBloodSugar;
	private String fastBloodSugar;
	private String diastoicBP;
	private String systoicBP;
	private String rhesusFactor;
	private String genetype;
	private String bloodGroup;
	private String comment;
	
	
	public String getPatientNumber() {
		return patientNumber;
	}
	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}
	
	
	public long getVitalsId() {
		return vitalsId;
	}
	public void setVitalsId(long vitalsId) {
		this.vitalsId = vitalsId;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getBodyMassIndex() {
		return bodyMassIndex;
	}
	public void setBodyMassIndex(String bodyMassIndex) {
		this.bodyMassIndex = bodyMassIndex;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getRespiratoryRate() {
		return respiratoryRate;
	}
	public void setRespiratoryRate(String respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}
	public String getPulseRate() {
		return pulseRate;
	}
	public void setPulseRate(String pulseRate) {
		this.pulseRate = pulseRate;
	}
	public String getRandomBloodSugar() {
		return randomBloodSugar;
	}
	public void setRandomBloodSugar(String randomBloodSugar) {
		this.randomBloodSugar = randomBloodSugar;
	}
	public String getFastBloodSugar() {
		return fastBloodSugar;
	}
	public void setFastBloodSugar(String fastBloodSugar) {
		this.fastBloodSugar = fastBloodSugar;
	}
	public String getDiastoicBP() {
		return diastoicBP;
	}
	public void setDiastoicBP(String diastoicBP) {
		this.diastoicBP = diastoicBP;
	}
	public String getSystoicBP() {
		return systoicBP;
	}
	public void setSystoicBP(String systoicBP) {
		this.systoicBP = systoicBP;
	}
	public String getRhesusFactor() {
		return rhesusFactor;
	}
	public void setRhesusFactor(String rhesusFactor) {
		this.rhesusFactor = rhesusFactor;
	}
	public String getGenetype() {
		return genetype;
	}
	public void setGenetype(String genetype) {
		this.genetype = genetype;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	

}
