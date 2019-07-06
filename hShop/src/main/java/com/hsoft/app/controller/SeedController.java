package com.hsoft.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsoft.app.bean.ResponseModel;
import com.hsoft.app.constant.HShopConstant;
import com.hsoft.app.model.Country;
import com.hsoft.app.model.Department;
import com.hsoft.app.model.EthinicGroup;
import com.hsoft.app.model.GlobalSettings;
import com.hsoft.app.model.ICDCodes;
import com.hsoft.app.model.Laboratory;
import com.hsoft.app.model.Occupation;
import com.hsoft.app.model.OperationCode;
import com.hsoft.app.model.PrefixSuffix;
import com.hsoft.app.model.Radiology;
import com.hsoft.app.model.Religion;
import com.hsoft.app.model.State;
import com.hsoft.app.repository.CountryRepository;
import com.hsoft.app.repository.DepartmentRepository;
import com.hsoft.app.repository.EthinicGroupRepository;
import com.hsoft.app.repository.GlobalSettingsRepository;
import com.hsoft.app.repository.ICDCodesRepository;
import com.hsoft.app.repository.LaboratoryRepository;
import com.hsoft.app.repository.OccupationRepository;
import com.hsoft.app.repository.OperationCodeRepository;
import com.hsoft.app.repository.PrefixSuffixRepository;
import com.hsoft.app.repository.RadiologyRepository;
import com.hsoft.app.repository.ReligionRepository;
import com.hsoft.app.repository.StateRepository;

/**
 * 
 * @author Accordify Solutions
 *
 */
@CrossOrigin(origins = "*")
@RestController

public class SeedController {

	@Autowired
	PrefixSuffixRepository prefixSuffixRepo;

	@Autowired
	ICDCodesRepository iCDCodesRepo;

	@Autowired
	RadiologyRepository radiologyRepo;

	@Autowired
	LaboratoryRepository laboratoryRepo;

	@Autowired
	OperationCodeRepository operationCodeRepo;
	
	@Autowired
	DepartmentRepository departmentRepo;
	
	@Autowired
	GlobalSettingsRepository globalSettingsRepo;
	
	@Autowired
	ReligionRepository religionRepo;

	@Autowired
	EthinicGroupRepository ethinicGroupRepo;
	
	@Autowired
	OccupationRepository occupationRepo;
	
	@Autowired
	CountryRepository countryRepo;
	
	@Autowired
	StateRepository stateRepo;
	/********************************************************************************************************************************
	 ************************************************** ALL THE POST MAPPINGS********************************************************
	 ********************************************************************************************************************************
	 */
	@PostMapping("/createUpdatePrefixSuffix")
	public Map<String, String> createDoctor(@RequestBody PrefixSuffix prefixSuffix) {
		Map<String, String> response = new HashMap<>();
		try {
			PrefixSuffix prefixSuffixs = prefixSuffixRepo.findByPrefixSuffix(prefixSuffix.getPrefixSuffix());
			if (prefixSuffixs != null) {
				prefixSuffixs.setPrefixSuffixValue(prefixSuffix.getPrefixSuffixValue());
				prefixSuffixRepo.save(prefixSuffixs);
			} else {
				prefixSuffixRepo.save(prefixSuffix);
			}
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "PrefixSuffix has been created");
			return response;

		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

	@PostMapping("/findPrefixSuffix")
	public PrefixSuffix getPrefixSuffix(@RequestBody PrefixSuffix prefixSuffix) {
		return prefixSuffixRepo.findByPrefixSuffixId(prefixSuffix.getPrefixSuffixId());
	}

	// To add single ICD code
	@PostMapping("/createUpdateICDCode")
	public ResponseModel createUpdateICDCode(@RequestBody ICDCodes iCDCodes) {
		ResponseModel response = new ResponseModel();
		try {
			iCDCodesRepo.save(iCDCodes);
			response.setStatus(HShopConstant.TRUE);
			response.setMessage("ICD Code has been inserted");
			return response;
		} catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			return response;
		}
	}

	// To add multiple ICD code
	@PostMapping("/createICDCodes")
	public ResponseModel createICDCodes(@RequestBody List<ICDCodes> iCDCodes) {
		ResponseModel response = new ResponseModel();
		try {
			for (ICDCodes icdCodes2 : iCDCodes) {
				iCDCodesRepo.save(icdCodes2);
			}
			response.setStatus(HShopConstant.TRUE);
			response.setMessage("All ICD Code has been inserted");
			return response;
		} catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			return response;
		}
	}

	@PostMapping("/findICDCode")
	public ResponseModel findICDCode(@RequestBody ICDCodes iCDCodes) {
		ResponseModel response = new ResponseModel();
		try {
			response.setData(
					iCDCodesRepo.findByDiseaseCodeOrDiseaseName(iCDCodes.getDiseaseCode(), iCDCodes.getDiseaseName()));
			response.setStatus(HShopConstant.TRUE);
			response.setMessage("ICD Code found");
			return response;
		} catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			return response;
		}
	}

	@PostMapping("/createUpdateRadiology")
	public ResponseModel createUpdateRadiology(@RequestBody Radiology radiology) {
		ResponseModel response = new ResponseModel();
		try {
			radiologyRepo.save(radiology);
			response.setStatus(HShopConstant.TRUE);
			response.setMessage("Radiology has been added");
			return response;
		} catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			response.setData(null);
			return response;
		}
	}

	@PostMapping("/findRadiology")
	public Radiology getRadiology(@RequestBody Radiology radiology) {
		return radiologyRepo.findByServiceIdOrServiceName(radiology.getServiceId(), radiology.getServiceName());
	}

	@PostMapping("/createUpdateLaboratory")
	public ResponseModel createUpdateLaboratory(@RequestBody Laboratory laboratory) {
		ResponseModel response = new ResponseModel();
		try {
			laboratoryRepo.save(laboratory);
			response.setStatus(HShopConstant.TRUE);
			response.setMessage("Laboratory has been added");
			return response;
		} catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			response.setData(null);
			return response;
		}
	}

	@PostMapping("/findLaboratory")
	public Laboratory getLaboratory(@RequestBody Laboratory laboratory) {
		return laboratoryRepo.findByServiceCodeOrLabService(laboratory.getServiceCode(), laboratory.getLabService());
	}

	@PostMapping("/createOpCode")
	public ResponseModel createOpCode(@RequestBody OperationCode operationCode) {
		ResponseModel response = new ResponseModel();
		try {
			operationCodeRepo.save(operationCode);
			response.setStatus(HShopConstant.TRUE);
			response.setMessage("Operation code has been added");
			return response;
		} catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			response.setData(null);
			return response;
		}
	}
	
	@PostMapping("/deleteDepartment")
	public ResponseModel deleteDepartment(@RequestBody Department department ) {
		ResponseModel response = new ResponseModel();
		try {
			 departmentRepo.deleteDepartment(department.getDepId());
			 response.setStatus(HShopConstant.TRUE);
			 response.setMessage("Department has been deleted");
			 return response;
			 
			
		}catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			response.setData(null);
			return response;
		}
	}
	
	@PostMapping("/createUpdateGlobalSettings")
	public ResponseModel createUpdateGlobalSettings(@RequestBody GlobalSettings globalSettings) {
		ResponseModel response = new ResponseModel();
		try {
		globalSettingsRepo.save(globalSettings);
		response.setStatus(HShopConstant.TRUE);
		response.setMessage("Global Settings Updated");
		return response;
		}catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			response.setData(null);
			return response;
		}
	}
	@PostMapping("/deleteGlobalSettings")
	public ResponseModel deleteGlobalSettings(@RequestBody GlobalSettings globalSettings ) {
		ResponseModel response = new ResponseModel();
		try {
			 globalSettingsRepo.deleteGlobalSettings(globalSettings.getGlobalSettingId());
			 response.setStatus(HShopConstant.TRUE);
			 response.setMessage("Global Setting has been deleted");
			 return response;
			 
			
		}catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			response.setData(null);
			return response;
		}
	}
		
	@PostMapping("/findGlobalSettings")
	public GlobalSettings getGlobalSettings(@RequestBody GlobalSettings globalSettings) {
		return globalSettingsRepo.findByLocationName(globalSettings.getLocationName());
	}
	
	
	@PostMapping("/createUpdateReligion")
	public ResponseModel createUpdateReligion(@RequestBody Religion religion) {
		ResponseModel response = new ResponseModel();
		try {
	       religionRepo.save(religion);
		response.setStatus(HShopConstant.TRUE);
		response.setMessage("Religion has been added");
		return response;
		}catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			response.setData(null);
			return response;
		}
	}
	
	@PostMapping("/createUpdateEthinicGroup")
	public ResponseModel createUpdateEthinicGroup(@RequestBody EthinicGroup ethinicGroup) {
		ResponseModel response = new ResponseModel();
		try {
	       ethinicGroupRepo.save(ethinicGroup);
		response.setStatus(HShopConstant.TRUE);
		response.setMessage("Ethinic Group has been added");
		return response;
		}catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			response.setData(null);
			return response;
		}
	}
	
	@PostMapping("/createUpdateOccupation")
	public ResponseModel createUpdateOccupation(@RequestBody Occupation occupation) {
		ResponseModel response = new ResponseModel();
		try {
	       occupationRepo.save(occupation);
		response.setStatus(HShopConstant.TRUE);
		response.setMessage("Ocupation has been added");
		return response;
		}catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			response.setData(null);
			return response;
		}
	}
	
	@PostMapping("/createUpdateCountry")
	public ResponseModel createUpdateCountry(@RequestBody Country country) {
		ResponseModel response = new ResponseModel();
		try {
	       countryRepo.save(country);
		response.setStatus(HShopConstant.TRUE);
		response.setMessage("Country has been added");
		return response;
		}catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			response.setData(null);
			return response;
		}
	}
	
	
	
	@PostMapping("/createUpdateState")
	public ResponseModel createUpdateState(@RequestBody State state) {
		ResponseModel response = new ResponseModel();
		try {
	       stateRepo.save(state);
		response.setStatus(HShopConstant.TRUE);
		response.setMessage("State has been added");
		return response;
		}catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			response.setData(null);
			return response;
		}
	}

	/********************************************************************************************************************************
	 ************************************************** ALL THE GET MAPPINGS*********************************************************
	 ********************************************************************************************************************************
	 */
	@GetMapping("/getPrefixSuffixs")
	public List<PrefixSuffix> getPrefixSuffixs() {
		return prefixSuffixRepo.findAll();
	}

	@GetMapping("/getAllICDCodes")
	public ResponseModel getAllICDCodes() {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setStatus(HShopConstant.TRUE);
		responseModel.setMessage("All ICD Codes found");
		responseModel.setData(iCDCodesRepo.findAll());
		return responseModel;
	}

	@GetMapping("/getAllRadiologies")
	public ResponseModel getAllRadiologies() {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setStatus(HShopConstant.TRUE);
		responseModel.setMessage("All radiologies found");
		responseModel.setData(radiologyRepo.findAll());
		return responseModel;
	}

	@GetMapping("/getAllLaboratories")
	public ResponseModel getAllLaboratories() {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setStatus(HShopConstant.TRUE);
		responseModel.setMessage("All Laboratories found");
		responseModel.setData(laboratoryRepo.findAll());
		return responseModel;
	}

	@GetMapping("/getAllOpCode")
	public ResponseModel getAllOpCode() {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setStatus(HShopConstant.TRUE);
		responseModel.setMessage("All Laboratories found");
		responseModel.setData(operationCodeRepo.findAll());
		return responseModel;
	}
	
	@GetMapping("/getGlobalSettings")
	public ResponseModel getGlobalSettings() {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setStatus(HShopConstant.TRUE);
		responseModel.setMessage("All GlobalSettings found");
		responseModel.setData(globalSettingsRepo.findAll());
		return responseModel;
	}
	
	@GetMapping("/getAllReligions")
	public ResponseModel getAllReligions() {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setStatus(HShopConstant.TRUE);
		responseModel.setMessage("All religions found");
		responseModel.setData(religionRepo.findAll());
		return responseModel;
	}

	@GetMapping("/getAllEthinicGroup")
	public ResponseModel getAllEthinicGroup() {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setStatus(HShopConstant.TRUE);
		responseModel.setMessage("All Ethinic Group found");
		responseModel.setData(ethinicGroupRepo.findAll());
		return responseModel;
	}
	
	@GetMapping("/getAllOccupation")
	public ResponseModel getAllOccupation() {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setStatus(HShopConstant.TRUE);
		responseModel.setMessage("All occupation found");
		responseModel.setData(occupationRepo.findAll());
		return responseModel;
	}

	@GetMapping("/getAllCountries")
	public ResponseModel getAllCountries() {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setStatus(HShopConstant.TRUE);
		responseModel.setMessage("All countries found");
		responseModel.setData(countryRepo.findAll());
		return responseModel;
	}


	@GetMapping("/getAllStates")
	public ResponseModel getAllStates() {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setStatus(HShopConstant.TRUE);
		responseModel.setMessage("All States found");
		responseModel.setData(stateRepo.findAll());
		return responseModel;
	}
}
