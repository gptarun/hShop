package com.hsoft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.Doctor;


public interface DoctorRepository extends JpaRepository<Doctor, Long>  {
	

	Doctor findByDoctorId(long id);
	
}
