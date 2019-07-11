package com.hsoft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsoft.app.model.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
	List<Module> findAll();
	List<Module>findById(long moduleId);
	Module findByModuleId(long moduleId);
}
