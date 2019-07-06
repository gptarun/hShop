package com.hsoft.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsoft.app.bean.ResponseModel;
import com.hsoft.app.bean.WardBean;
import com.hsoft.app.constant.HShopConstant;
import com.hsoft.app.model.AppointmentBooking;
import com.hsoft.app.model.Bed;
import com.hsoft.app.model.CodingIndexing;
import com.hsoft.app.model.Doctor;
import com.hsoft.app.model.GlobalSettings;
import com.hsoft.app.model.Patient;
import com.hsoft.app.model.PatientDischarge;
import com.hsoft.app.model.PatientHistory;
import com.hsoft.app.model.PatientIdNumber;
import com.hsoft.app.model.PrefixSuffix;
import com.hsoft.app.model.Scheme;
import com.hsoft.app.model.Ward;
import com.hsoft.app.model.WardBedTab;
import com.hsoft.app.repository.AppointmentRepository;
import com.hsoft.app.repository.BedRepository;
import com.hsoft.app.repository.CodingIndexingRepository;
import com.hsoft.app.repository.DoctorRepository;
import com.hsoft.app.repository.PatientDischargeRepository;
import com.hsoft.app.repository.PatientHistoryRepository;
import com.hsoft.app.repository.PatientIdNumberRepository;
import com.hsoft.app.repository.PatientRepository;
import com.hsoft.app.repository.PrefixSuffixRepository;
import com.hsoft.app.repository.SchemeRepository;
import com.hsoft.app.repository.WardBedTabRepository;
import com.hsoft.app.repository.WardRepository;
import com.hsoft.app.service.PatientService;

/**
 * 
 * @author Accordify Solutions
 *
 */
@CrossOrigin(origins = "*")
@RestController
public class PatientController {

	@Value("${file.upload-dir}")
	private String imageLocation;

	@Autowired
	PatientRepository patientRepo;

	@Autowired
	WardRepository wardRepo;

	@Autowired
	BedRepository bedRepo;

	@Autowired
	WardBedTabRepository wardBedRepo;

	@Autowired
	DoctorRepository doctorRepo;

	@Autowired
	private SchemeRepository schemeRepo;

	@Autowired
	PrefixSuffixRepository prefixSuffixRepo;

	@Autowired
	PatientDischargeRepository patientDischargeRepo;

	@Autowired
	PatientService patientService;

	@Autowired
	AppointmentRepository appointmentRepository;

	@Autowired
	PatientHistoryRepository patientHistoryRepo;

	@Autowired
	PatientIdNumberRepository patientIdNumberRepository;

	@Autowired
	CodingIndexingRepository codingIndexingRepo;

	// PatientHistory patienthistory=new PatientHistory();

	/********************************************************************************************************************************
	 ************************************************** ALL THE POST MAPPINGS********************************************************
	 ********************************************************************************************************************************
	 */
	@PostMapping("/createPatient")
	public Map<String, String> createPatient(@RequestBody Patient patient) {
		String pre = "";
		String suf = "";

		Map<String, String> response = new HashMap<>();
		try {
			List<PrefixSuffix> presuf = prefixSuffixRepo.findAll();
			for (PrefixSuffix prexsufx : presuf) {
				if (prexsufx.getPrefixSuffix().equalsIgnoreCase("Prefix") && prexsufx.getPrefixSuffixValue() != null) {
					pre = prexsufx.getPrefixSuffixValue();
				} else if (prexsufx.getPrefixSuffix().equalsIgnoreCase("Suffix")
						&& prexsufx.getPrefixSuffixValue() != null) {
					suf = prexsufx.getPrefixSuffixValue();
				}

			}
			String encodedImage = null;
			if (patient.getEncodedImage() != null && !patient.getEncodedImage().isEmpty()) {
				encodedImage = patient.getEncodedImage().substring(23, patient.getEncodedImage().length());
			}
			patient.setEncodedImage(null);
			patientRepo.save(patient);
			long patientId = patientRepo.currentValue();
			patient.setPatientNumber(pre + patientId + suf);
			// saving image to file system
			patientService.saveUserImage(encodedImage, patient.getPatientNumber());
			patient.setAttended(false);
			// This is the update call to insert Patient number
			patientRepo.save(patient);
			patientIdNumberRepository.save(new PatientIdNumber(patient.getPatientId(), patient.getPatientNumber()));
			patientService.PatientRegistrationHistory(patient);
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "Patient has been created id: " + patient.getPatientNumber());
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

	@PostMapping("/updatePatient")
	public Map<String, String> updatePatient(@RequestBody Patient patient) {
		Map<String, String> response = new HashMap<>();
		try {
			String encodedImage = null;
			if (patient.getEncodedImage() != null && !patient.getEncodedImage().isEmpty()) {
				encodedImage = patient.getEncodedImage().substring(23, patient.getEncodedImage().length());
			}
			patientService.saveUserImage(encodedImage, patient.getPatientNumber());
			patient.setEncodedImage(null);
			patientRepo.save(patient);
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE,
					"Patient " + patient.getPatientNumber() + " has been successfully edited");
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
		}
		return response;
	}

	@PostMapping("/createWard")
	public Map<String, String> createWard(@RequestBody Ward ward) {
		Map<String, String> response = new HashMap<>();
		try {
			wardRepo.save(ward);
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "Ward has been created");
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

	@PostMapping("/createBed")
	public Map<String, String> createBed(@RequestBody List<Bed> beds) {
		Map<String, String> response = new HashMap<>();
		try {
			for (Bed bed : beds) {
				bed.setVaccant(true);
				bedRepo.save(bed);
			}

			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "Bed has been created");
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

	@PostMapping("/createWardBed")
	public Map<String, String> createWardBed(@RequestBody WardBean wardBean) {
		Map<String, String> response = new HashMap<>();
		try {
			WardBedTab wardBed = wardBedRepo.findByWardIdAndBedId(wardBean.getWardId(), wardBean.getBedId().get(0));
			if (wardBed == null) {
				long wardId = wardBean.getWardId();
				for (Long bedId : wardBean.getBedId()) {
					wardBedRepo.save(new WardBedTab(wardId, bedId));
				}
				response.put(HShopConstant.STATUS, HShopConstant.TRUE);
				response.put(HShopConstant.MESSAGE, "Ward Bed Mapping has been created");
				return response;
			} else {
				response.put(HShopConstant.STATUS, HShopConstant.TRUE);
				response.put(HShopConstant.MESSAGE, "Ward Bed Mapping already exist");
				return response;
			}
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

	@PostMapping("/findVacantBeds")
	public List<Long> getVacantBeds(@RequestBody WardBean wardBean) {
		List<Long> unoccupiedBeds = new ArrayList<>();
		List<WardBedTab> wardBedTabs = new ArrayList<>();
		try {
			wardBedTabs = wardBedRepo.findByWardIdAndAssignedPatientId(wardBean.getWardId(), null);

			for (WardBedTab wardBedTab : wardBedTabs) {
				unoccupiedBeds.add(wardBedTab.getBedId());
			}
			return unoccupiedBeds;
		} catch (Exception e) {
			unoccupiedBeds.add(0L);
			return unoccupiedBeds;
		}
	}

	@PostMapping("/patientAdmission")
	public Map<String, Object> assignBed(@RequestBody WardBean wardBean) {
		Map<String, Object> response = new HashMap<>();
		try {
			WardBedTab wardBed = wardBedRepo.findByWardIdAndBedId(wardBean.getWardId(), wardBean.getBedId().get(0));
			wardBed.setAssignedPatientId(wardBean.getAssignedPatientId());
			wardBed.setDoctorName(wardBean.getDoctorName());
			wardBed.setAdmissionDate(wardBean.getAdmissionDate());
			wardBedRepo.save(wardBed);
			bedRepo.save(new Bed(wardBean.getBedId().get(0), false));
			patientService.patientAdmissionHistory(wardBean);
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "Patient has been assigned");
			response.put(HShopConstant.DATA, wardBed);
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

	@PostMapping("/wardTransfer")
	public Map<String, Object> wardTransfer(@RequestBody WardBean wardBean) {
		Map<String, Object> response = new HashMap<>();
		try {
			String assignpatient = wardBean.getAssignedPatientId();
			wardBedRepo.save(patientService.clearPatientBed(assignpatient));
			WardBedTab trasnsferredBed = wardBedRepo.findByWardIdAndBedId(wardBean.getWardId(),
					wardBean.getBedId().get(0));
			trasnsferredBed.setAssignedPatientId(assignpatient);
			trasnsferredBed.setAdmissionDate(wardBean.getAdmissionDate());
			trasnsferredBed.setDoctorName(wardBean.getDoctorName());
			wardBedRepo.save(trasnsferredBed);
			patientService.patientWardTransferHistory(wardBean);
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "Patient bed has been changed");
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}

	}

	@PostMapping("/createUpdateDoctor")
	public Map<String, String> createDoctor(@RequestBody Doctor doctor) {
		Map<String, String> response = new HashMap<>();
		try {
			doctorRepo.save(doctor);
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "Doctor has been created");
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}
	
	@PostMapping("/deleteDoctor")
	public ResponseModel deleteDoctor(@RequestBody Doctor doctor ) {
		ResponseModel response = new ResponseModel();
		try {
			 doctorRepo.deleteDoctor(doctor.getDoctorName());
			 response.setStatus(HShopConstant.TRUE);
			 response.setMessage("Doctor has been deleted");
			 return response;
			 
			
		}catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			response.setData(null);
			return response;
		}
	}

	@PostMapping("/createUpdateScheme")
	public Map<String, String> createScheme(@RequestBody Scheme scheme) {
		Map<String, String> response = new HashMap<>();
		try {
			schemeRepo.save(scheme);
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "Scheme has been created");
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

	@PostMapping("/patientDischarge")
	public Map<String, String> patientDischarge(@RequestBody PatientDischarge patientDischarge) {
		Map<String, String> response = new HashMap<>();
		try {
			patientDischargeRepo.save(patientDischarge);
			patientService.patientDischargeHistory(patientDischarge);
			wardBedRepo.save(patientService.clearPatientBed(patientDischarge.getPatientNumber()));
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "Patient has been dishcarged");
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

	@PostMapping("/findDischargeDetails")
	public Object getDischargeDetails(@RequestBody Patient patient) {
		return wardBedRepo.findByAssignedPatientId(patient.getPatientNumber());
	}

	@PostMapping("/createUpdateAppointment")
	public Map<String, String> createAppointment(@RequestBody AppointmentBooking appointmentBooking) {
		Map<String, String> response = new HashMap<>();
		try {
			appointmentRepository.save(appointmentBooking);
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "Appointment has been created");
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

	@PostMapping("/findPatientAppointment")
	public AppointmentBooking getPatientAppointment(@RequestBody AppointmentBooking appointmentBooking) {
		return appointmentRepository.findByAssignedPatientId(appointmentBooking.getAssignedPatientId());
	}

	@PostMapping("/findPatient")
	public Patient getPatient(@RequestBody Patient patient) {
		Patient patientObj;
		try {
			String encodedImage = patientService.getPatientImage(patient.getPatientNumber());
			patientObj = patientRepo.findByPatientIdOrPatientNumber(patient.getPatientId(), patient.getPatientNumber());
			patientObj.setEncodedImage(encodedImage);
		} catch (Exception e) {
			patientObj = patientRepo.findByPatientIdOrPatientNumber(patient.getPatientId(), patient.getPatientNumber());
		}
		return patientObj;
	}

	@PostMapping("/findDoctor")
	public Doctor getDoctor(@RequestBody Doctor doctor) {
		return doctorRepo.findByDoctorId(doctor.getDoctorId());
	}

	@PostMapping("/findBedPerWard")
	public List<Bed> getBedPerWard(@RequestBody WardBedTab wardBedTab) {
		return wardBedRepo.findByWardId(wardBedTab.getWardId());
	}

	/**
	 * This API is to get the wild card search list of the patient number.
	 * 
	 * @param patient
	 * @return
	 */
	@PostMapping("/findPatientNumber")
	public List<String> getPatientNumber(@RequestBody Patient patient) {
		List<String> patientNumbers = new ArrayList<>();
		List<Patient> patientList = patientRepo.searchWithJPQLQuery(patient.getPatientNumber());
		for (Patient patientObj : patientList) {
			patientNumbers.add(patientObj.getPatientNumber());
		}
		return patientNumbers;
	}

	@PostMapping("/createUpdatePatientHistory")
	public ResponseModel createUpdatePatientHistory(@RequestBody PatientHistory patientHistory) {
		ResponseModel response = new ResponseModel();
		try {
			patientHistoryRepo.save(patientHistory);
			response.setStatus(HShopConstant.TRUE);
			response.setMessage("Patient History has been created");
			return response;
		} catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			response.setData(null);
			return response;
		}
	}

	@PostMapping("/findPatientHistory")
	public ResponseModel findPatientHistory(@RequestBody PatientHistory patientHistory) {
		ResponseModel response = new ResponseModel();
		try {
			response.setStatus(HShopConstant.TRUE);
			response.setData(patientHistoryRepo.findByPatientNumber(patientHistory.getPatientNumber()));
			response.setMessage("Patient History has been found");
			return response;
		} catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			response.setData(null);
			return response;
		}
	}

	@PostMapping("/createCodeIndex")
	public ResponseModel createCodeIndex(@RequestBody CodingIndexing codingIndexing) {
		ResponseModel response = new ResponseModel();
		try {
			codingIndexingRepo.save(codingIndexing);
			response.setStatus(HShopConstant.TRUE);
			response.setMessage("Coding and indexing created");
			return response;
		} catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			response.setData(null);
			return response;
		}
	}

	@PostMapping("/findCodeIndex")
	public ResponseModel findCodeIndex(@RequestBody CodingIndexing codingIndexing) {
		ResponseModel response = new ResponseModel();
		try {
			response.setData(codingIndexingRepo.findByPatientNumber(codingIndexing.getPatientNumber()));
			response.setStatus(HShopConstant.TRUE);
			response.setMessage("Coding and indexing found");
			return response;
		} catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage("No Coding and indexing found for the Patient");
			response.setData(null);
			return response;
		}
	}

	@PostMapping("/findScheme")
	public Scheme getScheme(@RequestBody Scheme scheme) {
		return schemeRepo.findBySchemeName(scheme.getSchemeName());
	}
	
	


	/********************************************************************************************************************************
	 ************************************************** ALL THE GET MAPPINGS*********************************************************
	 ********************************************************************************************************************************
	 */

	@GetMapping("/getPatients")
	public List<Patient> getPatients() {
		return patientRepo.findAll();
	}

	@GetMapping("/getDoctors")
	public List<Doctor> getDoctors() {
		return doctorRepo.findAll();
	}

	@GetMapping("/getWards")
	public List<Ward> getWards() {
		return wardRepo.findAll();
	}

	@GetMapping("/getBeds")
	public List<Bed> getBeds() {
		return bedRepo.findAll();
	}

	@GetMapping("/getPatientNumbers")
	public List<String> getPatientNumbers() {
		List<Patient> patients = patientRepo.findAll();
		List<String> patientNumbers = new ArrayList<>();
		for (Patient patient : patients) {
			patientNumbers.add(patient.getPatientNumber());
		}
		return patientNumbers;
	}

	@GetMapping("/getSchemes")
	public List<Scheme> getScheme() {
		return schemeRepo.findAll();
	}

	@GetMapping("/getPatientHistories")
	public ResponseModel getPatientHistory() {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setStatus(HShopConstant.TRUE);
		responseModel.setMessage("Patient History found");
		responseModel.setData(patientHistoryRepo.findAll());
		return responseModel;
	}

	@GetMapping("/getPatientIdNumber")
	public ResponseModel getPatientIdNumber() {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setStatus(HShopConstant.TRUE);
		responseModel.setMessage("Patient Id Number mapping found");
		responseModel.setData(patientIdNumberRepository.findAll());
		return responseModel;
	}

	@GetMapping("/getVacantBeds")
	public List<Long> getVacantBeds() {
		List<Long> unoccupiedBeds = new ArrayList<>();
		List<Bed> beds = new ArrayList<>();
		try {
			beds = bedRepo.findByIsVaccant(true);

			for (Bed bed : beds) {
				unoccupiedBeds.add(bed.getBedId());
			}
			return unoccupiedBeds;
		} catch (Exception e) {
			unoccupiedBeds.add(0L);
			return unoccupiedBeds;
		}
	}

}
