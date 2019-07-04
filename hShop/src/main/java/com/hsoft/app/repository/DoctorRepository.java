package com.hsoft.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hsoft.app.model.Doctor;


public interface DoctorRepository extends JpaRepository<Doctor, Long>  {
	

	Doctor findByDoctorId(long id);

	@Modifying
	@Transactional
	@Query(value=" delete from doctor where doctor_name = :doctorName", nativeQuery = true)
	void deleteDoctor(@Param("doctorName") String doctorName);
	
	
}
