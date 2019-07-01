package com.hsoft.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsoft.app.model.Patient;
import com.hsoft.app.repository.PatientRepository;

/**
 * 
 * @author Accordify Solutions
 *
 */
@CrossOrigin(origins = "*")
@RestController
public class PatientClerkingController {

	@Autowired
	PatientRepository patientRepo;

	@GetMapping("/patientUnattended")
	public List<Patient> patientUnattended() {
		return patientRepo.findByIsAttended(false);

	}
}
