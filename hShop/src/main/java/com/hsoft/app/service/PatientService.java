package com.hsoft.app.service;

import java.io.File;
import java.nio.file.Files;

public class PatientService {

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
}
