package com.hsoft.app.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hsoft.app.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

	List<Location> findAll();

	List<Location> findByLocationName(String locationName);

	
	@Modifying
	@Transactional
	@Query(value=" delete from location where location_name = :locationName", nativeQuery = true)
	void deleteLocation(@Param("locationName") String locationName);
	

}
