package com.hsoft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hsoft.app.model.RoleModuleTab;

@Repository
public interface RoleModuleRepository extends JpaRepository<RoleModuleTab, Long> {
	List<RoleModuleTab> findAll();

	RoleModuleTab findById(long roleModuleId);

	List<RoleModuleTab> findModuleIdByRoleId(long roleModuleId);

	List<RoleModuleTab> findByRoleId(long roleId);

	@Modifying
	@Transactional
	@Query(value = "delete from role_module rm where rm.role_id=:roleId", nativeQuery = true)
	int deleteRoleModuleMapping(@Param("roleId") long roleId);
}
