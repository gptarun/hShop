package com.hsoft.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hsoft.app.bean.WardBean;
import com.hsoft.app.constant.HShopConstant;
import com.hsoft.app.model.AppointmentBooking;
import com.hsoft.app.model.Bed;
import com.hsoft.app.model.Doctor;
import com.hsoft.app.model.Patient;
import com.hsoft.app.model.PatientDischarge;
import com.hsoft.app.model.PrefixSuffix;
import com.hsoft.app.model.Scheme;
import com.hsoft.app.model.Ward;
import com.hsoft.app.model.WardBedTab;
import com.hsoft.app.repository.AppointmentRepository;
import com.hsoft.app.repository.BedRepository;
import com.hsoft.app.repository.DoctorRepository;
import com.hsoft.app.repository.PatientDischargeRepository;
import com.hsoft.app.repository.PatientRepository;
import com.hsoft.app.repository.PrefixSuffixRepository;
import com.hsoft.app.repository.SchemeRepository;
import com.hsoft.app.repository.WardBedTabRepository;
import com.hsoft.app.repository.WardRepository;
import com.hsoft.app.service.PatientService;

/**
 * 
 * @author Tarun
 *
 */
@CrossOrigin(origins = "*")
@RestController
public class PatientController {

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

	/**
	 * create
	 */
	@PostMapping("/createPatient")
	public Map<String, String> createPatient(@RequestBody Patient patient) {
		String pre = "";
		String suf = "";
		Map<String, String> response = new HashMap<>();
		try {
			long patientId = patientRepo.currentValue();
			patientId++;
			List<PrefixSuffix> presuf = prefixSuffixRepo.findAll();
			for (PrefixSuffix prexsufx : presuf) {
				if (prexsufx.getPrefixSuffix().equals("Prefix") && prexsufx.getPrefixSuffixValue() != null) {
					pre = prexsufx.getPrefixSuffixValue();
				} else if (prexsufx.getPrefixSuffix().equals("Suffix") && prexsufx.getPrefixSuffixValue() != null) {
					suf = prexsufx.getPrefixSuffixValue();
				}

			}
			patient.setPatientNumber(pre + patientId + suf);

			patientRepo.save(patient);
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "Patient has been created");
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
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

	@PostMapping("/getVacantBeds")
	public List<Long> getVacantBeds(@RequestBody WardBean wardBean) {
		List<Long> unoccupiedBeds = new ArrayList<>();
		List<WardBedTab> wardBedTabs = new ArrayList<>();
		try {
			wardBedTabs = wardBedRepo.findByWardIdAndAssignedPatientId(wardBean.getWardId(), 0L);

			for (WardBedTab wardBedTab : wardBedTabs) {
				unoccupiedBeds.add(wardBedTab.getBedId());
			}
			return unoccupiedBeds;
		} catch (Exception e) {
			unoccupiedBeds.add(0L);
			return unoccupiedBeds;
		}
	}

	@PostMapping("/assignBed")
	public Map<String, Object> assignBed(@RequestBody WardBean wardBean) {
		Map<String, Object> response = new HashMap<>();
		try {
			WardBedTab wardBed = wardBedRepo.findByWardIdAndBedId(wardBean.getWardId(), wardBean.getBedId().get(0));
			wardBed.setAssignedPatientId(wardBean.getAssignedPatientId());
			wardBed.setDoctorName(wardBean.getDoctorName());
			wardBed.setAdmissionDate(wardBean.getAdmissionDate());
			wardBedRepo.save(wardBed);
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
			long assignpatient = wardBean.getAssignedPatientId();
			wardBedRepo.save(patientService.clearPatientBed(assignpatient));
			WardBedTab trasnsferredBed = wardBedRepo.findByWardIdAndBedId(wardBean.getWardId(),
					wardBean.getBedId().get(0));
			trasnsferredBed.setAssignedPatientId(assignpatient);
			trasnsferredBed.setAdmissionDate(wardBean.getAdmissionDate());
			wardBedRepo.save(trasnsferredBed);
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "Patient bed has been changed");
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}

	}

	@PostMapping("/createDoctor")
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

	@PostMapping("/createScheme")
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

	@GetMapping("/getSchemes")
	public List<Scheme> getScheme() {
		List<Scheme> schemes = schemeRepo.findAll();
		return schemes;
	}

	@PostMapping("/patientDischarge")
	public Map<String, String> patientDischarge(@RequestBody PatientDischarge patientDischarge,
			@RequestParam Long patientNumber) {
		Map<String, String> response = new HashMap<>();
		try {
			patientDischargeRepo.save(patientDischarge);
			wardBedRepo.save(patientService.clearPatientBed(patientNumber));
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "Patient has been dishcarged");
			return response;
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

	@PostMapping("/getDischargeDetails")
	public Object getDischargeDetails(@RequestBody Patient patient) {
		return wardBedRepo.findByAssignedPatientId(patient.getPatientId());
	}

	@PostMapping("/createAppointment")
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

	@PostMapping("/getPatientAppointment")
	public AppointmentBooking getPatientAppointment(@RequestBody AppointmentBooking appointmentBooking) {
		return appointmentRepository.findByAssignedPatientId(appointmentBooking.getAssignedPatientId());
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
		return patientRepo.findByPatientIdOrPatientNumber(patient.getPatientId(), patient.getPatientNumber());
	}

	@GetMapping("/getDoctors")
	public List<Doctor> getDoctors() {
		return doctorRepo.findAll();
	}

	@PostMapping("/getDoctor")
	public Doctor getDoctor(@RequestBody Doctor doctor) {
		return doctorRepo.findByDoctorId(doctor.getDoctorId());
	}

	@GetMapping("/getWards")
	public List<Ward> getWards() {
		return wardRepo.findAll();
	}

	@GetMapping("/getBeds")
	public List<Bed> getBeds() {
		return bedRepo.findAll();
	}

	@PostMapping("/getBedPerWard")
	public List<Bed> getBedPerWard(@RequestBody WardBedTab wardBedTab) {
		return wardBedRepo.findByWardId(wardBedTab.getWardId());
	}

	/**
	 * This API is to get the wild card search list of the patient number.
	 * 
	 * @param patient
	 * @return
	 */
	@PostMapping("/getPatientNumber")
	public List<String> getPatientNumber(@RequestBody Patient patient) {
		List<String> patientNumbers = new ArrayList<>();
		List<Patient> patientList = patientRepo.searchWithJPQLQuery(patient.getPatientNumber());
		for (Patient patientObj : patientList) {
			patientNumbers.add(patientObj.getPatientNumber());
		}
		return patientNumbers;
	}

	/**
	 * This API is to get the wild card search list of the patient number.
	 * 
	 * @param patient
	 * @return
	 */
	@GetMapping("/getPatientNumbers")
	public List<String> getPatientNumbers() {
		List<Patient> patients = patientRepo.findAll();
		List<String> patientNumbers = new ArrayList<>();
		for (Patient patient : patients) {
			patientNumbers.add(patient.getPatientNumber());
		}
		return patientNumbers;
	}

}
