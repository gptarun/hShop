package com.hsoft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.PatientHistory;

public interface PatientHistoryRepository extends JpaRepository<PatientHistory, Long> {

	List<PatientHistory> findByPatientNumberAndIsActive(String patientNumber, boolean isActive);

	List<PatientHistory> findByPatientNumber(String patientNumber);
	
}
