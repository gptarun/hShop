package com.hsoft.app.service;

import java.io.File;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsoft.app.model.WardBedTab;
import com.hsoft.app.repository.WardBedTabRepository;

@Service
public class PatientService {

	@Autowired
	WardBedTabRepository wardBedRepo;

	public byte[] getPatientImage(String patientNumber, String filePath) {
		try {
			filePath = filePath + patientNumber + ".jpg";
			System.out.println(filePath);
			File file = new File(filePath);
			return Files.readAllBytes(file.toPath());
		} catch (Exception e) {
			return new byte[0];
		}
	}

	public WardBedTab clearPatientBed(long assignedPatientId) {
		WardBedTab wardBedassign = wardBedRepo.findByAssignedPatientId(assignedPatientId);
		wardBedassign.setAssignedPatientId(0L);
		wardBedassign.setAdmissionDate(null);
		wardBedassign.setDoctorName(null);
		return wardBedassign;
	}
}
