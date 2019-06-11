package com.hsoft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsoft.app.model.RoleModuleTab;

@Repository
public interface RoleModuleRepository extends JpaRepository<RoleModuleTab, Long> {
	List<RoleModuleTab> findAll();

	RoleModuleTab findById(long roleModuleId);

	List<RoleModuleTab> findModuleIdByRoleId(long roleModuleId);
}
