package com.hsoft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.Vitals;

public interface VitalsRepository extends JpaRepository<Vitals, Long>  {

	Vitals findByPatientNumber(String patientNumber);

}
