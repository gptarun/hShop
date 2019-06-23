package com.hsoft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsoft.app.model.PatientSchemeDet;

@Repository
public interface PatientSchemeDetRepository extends JpaRepository<PatientSchemeDet, Long> {
	List<PatientSchemeDet> findAll();
	PatientSchemeDet findById(long userId);
}
