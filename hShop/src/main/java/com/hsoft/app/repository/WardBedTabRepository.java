package com.hsoft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hsoft.app.model.Bed;
import com.hsoft.app.model.WardBedTab;

public interface WardBedTabRepository extends JpaRepository<WardBedTab, Long> {

	List<Bed> findByWardId(long wardId);
	List<WardBedTab> findByWardIdAndAssignedPatientId(long wardId, String assignedPatientId);
	WardBedTab findByWardIdAndBedId(long wardId, long bedId);
	WardBedTab findByAssignedPatientId(String assignedPatientId);
	WardBedTab findByDoctorName(String doctorName);
	
	@Query(value="select doctor_name FROM ward_bed w where w.assigned_Patient_Id = :patientNumber", nativeQuery = true)
	String DoctorName(@Param("patientNumber") String PatientNumber );
}
