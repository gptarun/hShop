package com.hsoft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.PatientHistory;

public interface PatientHistoryRepository extends JpaRepository<PatientHistory, Long> {

}
