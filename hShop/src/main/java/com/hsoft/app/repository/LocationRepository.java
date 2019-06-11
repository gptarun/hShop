package com.hsoft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

	List<Location> findAll();

	List<Location> findByLocationName(String locationName);

}
