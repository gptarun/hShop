package com.hsoft.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsoft.app.constant.HShopConstant;
import com.hsoft.app.model.Patient;
import com.hsoft.app.repository.PatientRepository;

/**
 * 
 * @author Tarun
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PatientController {

	@Autowired
	PatientRepository patientRepo;

	/**
	 * create
	 */
	@PostMapping("/createPatient")
	public Map<String, String> createUser(@RequestBody Patient user) {
		Map<String, String> response = new HashMap<>();
		try {
			patientRepo.save(user);
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "Patient has been created");
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

	/**
	 * Update
	 */
	@PutMapping("/updatePatient")
	public Map<String, String> updateUser(@RequestBody Patient user) {
		Map<String, String> response = new HashMap<>();
		try {
			// patiemtRepo.
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "Patient has been created");
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

	/**
	 * Get
	 */

	@GetMapping("/getPatients")
	public List<Patient> getPatients() {
		return patientRepo.findAll();
	}

	@PostMapping("/getPatient")
	public Patient getPatient(@RequestBody Patient patient) {
		return patientRepo.findByPatientId(patient.getPatientId());
	}
}
