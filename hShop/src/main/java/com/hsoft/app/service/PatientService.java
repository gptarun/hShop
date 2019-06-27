package com.hsoft.app.service;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsoft.app.model.Patient;
import com.hsoft.app.model.PatientDischarge;
import com.hsoft.app.model.PatientHistory;
import com.hsoft.app.model.WardBedTab;
import com.hsoft.app.repository.PatientHistoryRepository;
import com.hsoft.app.repository.WardBedTabRepository;
/**
 * 
 * @author Accordify Solutions
 *
 */
@Service
public class PatientService {

	private static final boolean True = false;

	@Autowired
	WardBedTabRepository wardBedRepo;
	
	@Autowired
	PatientHistoryRepository patientHistoryRepo;

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

	public WardBedTab clearPatientBed(String assignedPatientId) {
		WardBedTab wardBedassign = wardBedRepo.findByAssignedPatientId(assignedPatientId);
		wardBedassign.setAssignedPatientId(null);
		wardBedassign.setAdmissionDate(null);
		wardBedassign.setDoctorName(null);
		return wardBedassign;
	}
	
	public void PatientRegistrationHistory(Patient patient)
	{    PatientHistory patienthistory=new PatientHistory();
	     patienthistory.setPatientNumber(patient.getPatientNumber());
	     patienthistory.setFirstName(patient.getFirstName());
	     patienthistory.setLastName(patient.getLastName());
	     patientHistoryRepo.save(patienthistory);
	     
     }
	
	public void PatientAdmissionHistory(WardBedTab wardbedtab)
	{   //TODO To make the isActive status true at the time of patient admission
	    List<PatientHistory> patienthistory=patientHistoryRepo.findByPatientNumber(wardbedtab.getAssignedPatientId());
	    
	    for(PatientHistory patienthist:patienthistory)
	    	if(patienthist.isActive()==True)
	    	{
	    		patienthist.setAdmissionDate(wardbedtab.getAdmissionDate());
				patienthist.setLastWardId(wardbedtab.getWardId());
				patienthist.setLastBedId(wardbedtab.getBedId());
				patienthist.setConsultingDoctor(wardbedtab.getDoctorName());
				patientHistoryRepo.save(patienthist);
	    	}
	    	  
	 }
	public void PatientDischargeHistory(PatientDischarge patientdischarge)
	{   
	    List<PatientHistory> patienthistory=patientHistoryRepo.findByPatientNumber(patientdischarge.getPatientNumber());
	    for(PatientHistory patienthist:patienthistory)
	    	if(patienthist.isActive()==True)
	    	{
	    		patienthist.setDischargeDoctor(patientdischarge.getConsultant());
				patienthist.setDischargeDate(patientdischarge.getDischargeDate());
				patienthist.setDischargeStatus(patientdischarge.getDischargeStatus());
				patientHistoryRepo.save(patienthist);
	    	}
	    	  
	 }
	
	
	
	
}