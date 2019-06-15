package com.hsoft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	Patient findByPatientId(long id);

}
