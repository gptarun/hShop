package com.hsoft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hsoft.app.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

	Patient findByPatientId(long id);
	
	Patient findByPatientNumber(String id);

	Patient findByPatientIdOrPatientNumber(long patientId, String patientNumnber);

	@Query(value = "SELECT * FROM Patient p WHERE p.patient_number LIKE CONCAT('%',:searchTerm,'%')", nativeQuery = true)
	List<Patient> searchWithJPQLQuery(@Param("searchTerm") String searchTerm);
	
	@Query(value = "select last_value FROM patient_seq", nativeQuery = true)
	long currentValue(); 
    
	
    	
}
