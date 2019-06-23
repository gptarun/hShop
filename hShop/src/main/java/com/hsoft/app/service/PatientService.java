package com.hsoft.app.service;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsoft.app.model.WardBedTab;
import com.hsoft.app.repository.WardBedTabRepository;

@Service
public class PatientService {

	@Autowired
	WardBedTabRepository wardBedRepo;

	public String getPatientImage(String patientNumber) throws URISyntaxException {
		String encodedImage = "";
		ClassLoader classLoader = getClass().getClassLoader();
		URI imageURI = classLoader.getResource("static/images/" + patientNumber + ".jpg").toURI();
		File imageFile = new File(imageURI);
		File newImageFile = new File(imageFile.getAbsolutePath());
		try (FileInputStream fileInputStreamReader = new FileInputStream(newImageFile);) {
			byte[] bytes = new byte[(int) newImageFile.length()];
			fileInputStreamReader.read(bytes);
			encodedImage = new String(Base64.encodeBase64(bytes));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encodedImage;

	}

	public WardBedTab clearPatientBed(long assignedPatientId) {
		WardBedTab wardBedassign = wardBedRepo.findByAssignedPatientId(assignedPatientId);
		wardBedassign.setAssignedPatientId(0L);
		wardBedassign.setAdmissionDate(null);
		wardBedassign.setDoctorName(null);
		return wardBedassign;
	}
}
