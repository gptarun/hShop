package com.hsoft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsoft.app.model.Scheme;

@Repository
public interface SchemeRepository extends JpaRepository<Scheme, Long> {
	List<Scheme> findAll();
	Scheme findById(long userId);
}
