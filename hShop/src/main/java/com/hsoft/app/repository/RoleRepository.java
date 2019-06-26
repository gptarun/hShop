package com.hsoft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	List<Role> findAll();

	Role findByRoleId(long roleId);
}
