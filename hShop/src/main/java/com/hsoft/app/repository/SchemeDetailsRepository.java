package com.hsoft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsoft.app.model.SchemeDetails;

@Repository
public interface SchemeDetailsRepository extends JpaRepository<SchemeDetails, Long> {
	List<SchemeDetails> findAll();
	SchemeDetails findById(long userId);
}
