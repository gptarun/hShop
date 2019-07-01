package com.hsoft.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsoft.app.bean.ResponseModel;
import com.hsoft.app.constant.HShopConstant;
import com.hsoft.app.model.ClerkingDesk;
import com.hsoft.app.model.Patient;
import com.hsoft.app.repository.ClerkingDeskRepository;
import com.hsoft.app.repository.CodingIndexingRepository;
import com.hsoft.app.repository.PatientRepository;
import com.hsoft.app.repository.WardBedTabRepository;

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
	
	@Autowired
	WardBedTabRepository wardBedRepo;
	
	@Autowired
	CodingIndexingRepository codingIndexingRepo;
	
	@Autowired
	ClerkingDeskRepository clerkingDeskRepo;
	
	
	
	
	
	@PostMapping("/createClerkingDesk")
	public ResponseModel createClerkingDesk(@RequestBody ClerkingDesk clerkingDesk) {
		ResponseModel response = new ResponseModel();
		try {
		    clerkingDesk.setAssignedDoctor(wardBedRepo.DoctorName(clerkingDesk.getPatientNumber()));
	        clerkingDesk.setProvisionalDiagnosis(codingIndexingRepo.ProvisionalDiagnosis(clerkingDesk.getPatientNumber()));
	        clerkingDeskRepo.save(clerkingDesk);
	        Patient patient=patientRepo.findByPatientNumber(clerkingDesk.getPatientNumber());
	        patient.setAttended(true);
			response.setStatus(HShopConstant.TRUE);
			response.setMessage("Patient Details has been saved");
			return response;
		} catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			response.setData(null);
			return response;
		}
		}
	
	@GetMapping("/patientStatus")
	public List<Patient> patientStatus() {
		return patientRepo.findAll();
        }
	
	
	@GetMapping("/getPatientStatus")
	public ResponseModel getPatientStatus() {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setStatus(HShopConstant.TRUE);
		responseModel.setMessage("Patient Status Details found");
		responseModel.setData(patientRepo.findAll());
		return responseModel;
	}
	
	
	 }
