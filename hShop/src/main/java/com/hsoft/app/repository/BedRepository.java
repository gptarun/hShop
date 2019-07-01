package com.hsoft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.Bed;

public interface BedRepository extends JpaRepository<Bed, Long> {

	List<Bed> findByIsVaccant(boolean status);
}
