package com.hsoft.app.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hsoft.app.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	List<Department> findAll();
	Department findById(long depId);
	
	
	@Modifying
	@Transactional
	@Query(value=" delete from department where dep_id = :depId", nativeQuery = true)
	void deleteDepartment(@Param("depId") long depId );
}
