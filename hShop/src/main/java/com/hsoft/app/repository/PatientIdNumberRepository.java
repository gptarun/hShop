package com.hsoft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.PatientIdNumber;

public interface PatientIdNumberRepository extends JpaRepository<PatientIdNumber, Long> {

}
