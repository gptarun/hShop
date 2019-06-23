package com.hsoft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.CodingIndexing;

public interface CodingIndexingRepository extends JpaRepository<CodingIndexing, Long> {

	List<CodingIndexing> findByPatientNumber(String patientNumber);

}
