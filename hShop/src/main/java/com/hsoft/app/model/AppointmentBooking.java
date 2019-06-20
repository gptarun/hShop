package com.hsoft.app.model;

import java.util.Date;

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
@Table(name = "appointment")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class AppointmentBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointmentSequence")
	@SequenceGenerator(name = "appointmentSequence", sequenceName = "APP_SEQ", allocationSize = 1)
	private long appointmentId;
	private long assignedPatientId;
	private String consultant;
	private String clinic;
	private Date appointmentDate;

	public long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getConsultant() {
		return consultant;
	}

	public void setConsultant(String consultant) {
		this.consultant = consultant;
	}

	public String getClinic() {
		return clinic;
	}

	public void setClinic(String clinic) {
		this.clinic = clinic;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public long getAssignedPatientId() {
		return assignedPatientId;
	}

	public void setAssignedPatientId(long assignedPatientId) {
		this.assignedPatientId = assignedPatientId;
	}

}
