package com.hsoft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsoft.app.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	List<Role> findAll();
	Role findById(long userId);
}
