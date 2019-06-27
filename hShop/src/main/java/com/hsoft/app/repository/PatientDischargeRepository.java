package com.hsoft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.PatientDischarge;

public interface PatientDischargeRepository extends JpaRepository<PatientDischarge, Long> {
	
	PatientDischarge findByPatientNumber(String id);

}
