package com.hsoft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hsoft.app.model.Scheme;

@Repository
public interface SchemeRepository extends JpaRepository<Scheme, Long> {
	List<Scheme> findAll();

	Scheme findById(long userId);

	Scheme findBySchemeName(String schemeName);

	@Query(value = "SELECT scheme_name from scheme", nativeQuery = true)
	List<String> getSchemeNameList();

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM scheme_plan WHERE scheme_id=:schemeId", nativeQuery = true)
	int deletePlanSchemeMapping(@Param("schemeId") long schemeId);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM plan WHERE plan_id=:planId", nativeQuery = true)
	int deletePlan(@Param("planId") long planId);

	@Modifying
	@Transactional
	@Query(value = "SELECT plan_id FROM scheme_plan WHERE scheme_id=:schemeId", nativeQuery = true)
	List<Long> getPlanIds(@Param("schemeId") long schemeId);

}
