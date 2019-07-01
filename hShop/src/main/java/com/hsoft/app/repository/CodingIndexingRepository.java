package com.hsoft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hsoft.app.model.CodingIndexing;

public interface CodingIndexingRepository extends JpaRepository<CodingIndexing, Long> {

	List<CodingIndexing> findByPatientNumber(String patientNumber);
	
	@Query(value="select provisional_diagnosis FROM coding_indexing c where c.patient_number = :patientNumber", nativeQuery = true)
	String ProvisionalDiagnosis(@Param("patientNumber") String PatientNumber );

}
