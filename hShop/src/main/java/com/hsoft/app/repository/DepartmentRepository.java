package com.hsoft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	List<Department> findAll();
	Department findById(long depId);
}
