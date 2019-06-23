package com.hsoft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.ICDCodes;

public interface ICDCodesRepository extends JpaRepository<ICDCodes, Long> {

	ICDCodes findByDiseaseCodeOrDiseaseName(String diseaseCode, String diseaseName);
}
