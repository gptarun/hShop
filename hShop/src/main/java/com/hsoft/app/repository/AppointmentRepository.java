package com.hsoft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.AppointmentBooking;

public interface AppointmentRepository extends JpaRepository<AppointmentBooking, Long> {

	AppointmentBooking findByAssignedPatientId(String assignedPatientId);
}
