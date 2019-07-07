package com.hsoft.app.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hsoft.app.bean.WardBean;
import com.hsoft.app.model.Patient;
import com.hsoft.app.model.PatientDischarge;
import com.hsoft.app.model.PatientHistory;
import com.hsoft.app.model.Scheme;
import com.hsoft.app.model.Ward;
import com.hsoft.app.model.WardBedTab;
import com.hsoft.app.repository.PatientHistoryRepository;
import com.hsoft.app.repository.SchemeRepository;
import com.hsoft.app.repository.WardBedTabRepository;
import com.hsoft.app.repository.WardRepository;

/**
 * 
 * @author Accordify Solutions
 *
 */
@Service
public class PatientService {

	@Autowired
	WardBedTabRepository wardBedRepo;

	@Autowired
	PatientHistoryRepository patientHistoryRepo;

	@Autowired
	WardRepository wardRepo;

	@Autowired
	SchemeRepository schemeRepo;

	@Value("${file.upload-dir}")
	private String imageLocation;

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

	public void PatientRegistrationHistory(Patient patient) {
		PatientHistory patienthistory = new PatientHistory();
		patienthistory.setPatientNumber(patient.getPatientNumber());
		patienthistory.setFirstName(patient.getFirstName());
		patienthistory.setLastName(patient.getLastName());
		patientHistoryRepo.save(patienthistory);

	}

	public void patientAdmissionHistory(WardBean wardBean) { // TODO To make the isActive status true at the time of
																// patient admission
		List<PatientHistory> patienthistory = patientHistoryRepo.findByPatientNumber(wardBean.getAssignedPatientId());
		PatientHistory pht = patienthistory.get(patienthistory.size() - 1);
		pht.setActive(true);
		for (PatientHistory patienthist : patienthistory)
			if (patienthist.isActive()) {
				patienthist.setAdmissionDate(wardBean.getAdmissionDate());
				patienthist.setLastWardId(wardBean.getWardId());
				Ward ward = wardRepo.findBywardId(wardBean.getWardId());
				patienthist.setWardName(ward.getWardName());
				patienthist.setLastBedId(wardBean.getBedId().get(0));
				patienthist.setConsultingDoctor(wardBean.getDoctorName());
				patientHistoryRepo.save(patienthist);
			}

	}

	public void patientDischargeHistory(PatientDischarge patientDischarge) {
		List<PatientHistory> patienthistory = patientHistoryRepo
				.findByPatientNumber(patientDischarge.getPatientNumber());
		for (PatientHistory patienthist : patienthistory)
			if (patienthist.isActive()) {
				patienthist.setDischargeDoctor(patientDischarge.getConsultant());
				patienthist.setDischargeDate(patientDischarge.getDischargeDate());
				patienthist.setDischargeStatus(patientDischarge.getDischargeStatus());
				patienthist.setActive(false);
				patientHistoryRepo.save(patienthist);
			}

	}

	public void patientWardTransferHistory(WardBean wardBean) {
		List<PatientHistory> patienthistory = patientHistoryRepo.findByPatientNumber(wardBean.getAssignedPatientId());
		for (PatientHistory patienthist : patienthistory)
			if (patienthist.isActive()) {
				patienthist.setAdmissionDate(wardBean.getAdmissionDate());
				patienthist.setLastWardId(wardBean.getWardId());
				Ward ward = wardRepo.findBywardId(wardBean.getWardId());
				patienthist.setWardName(ward.getWardName());
				patienthist.setLastBedId(wardBean.getBedId().get(0));
				patienthist.setConsultingDoctor(wardBean.getDoctorName());
				patientHistoryRepo.save(patienthist);
			}
	}

	public void saveUserImage(String saveImage, String patientNumber) {
		try {
			if (saveImage != null && !saveImage.isEmpty()) {
				File file = new File(imageLocation + patientNumber + ".jpg");
				byte[] byteImage = Base64.decodeBase64(saveImage);
				OutputStream os = new FileOutputStream(file);
				os.write(byteImage);
				os.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateSchemeDetails(Scheme scheme) {
		try {
			List<Long> planIds = schemeRepo.getPlanIds(scheme.getSchemeId());
			schemeRepo.deletePlanSchemeMapping(scheme.getSchemeId());
			for (Long planId : planIds) {
				schemeRepo.deletePlan(planId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}