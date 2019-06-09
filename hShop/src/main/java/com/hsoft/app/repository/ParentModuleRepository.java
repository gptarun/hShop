package com.hsoft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.ParentModule;

public interface ParentModuleRepository extends JpaRepository<ParentModule, Long> {
	List<ParentModule> findAll();

	ParentModule findById(long pmId);
}
