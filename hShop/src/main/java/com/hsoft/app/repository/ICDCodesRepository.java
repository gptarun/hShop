package com.hsoft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.ICDCodes;

public interface ICDCodesRepository extends JpaRepository<ICDCodes, Long> {

	List<ICDCodes> findByDiseaseCodeOrDiseaseName(String diseaseCode, String diseaseName);
}
