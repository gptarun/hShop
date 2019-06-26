package com.hsoft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.Laboratory;

public interface LaboratoryRepository extends JpaRepository<Laboratory, Long>{

     Laboratory findByServiceCodeOrLabService(long serviceCode, String labService);
     
	
}
