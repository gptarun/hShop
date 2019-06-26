package com.hsoft.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.Radiology;

public interface RadiologyRepository extends JpaRepository<Radiology, Long>{
	
	
	Radiology findByServiceIdOrServiceName(long serviceId, String serviceName);
	

	
}
