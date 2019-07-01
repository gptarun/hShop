package com.hsoft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.PatientDrug;

public interface PatientDrugRepository extends JpaRepository<PatientDrug, Long> {

}
