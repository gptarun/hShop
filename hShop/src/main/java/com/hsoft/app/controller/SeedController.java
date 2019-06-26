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
import com.hsoft.app.model.ICDCodes;
import com.hsoft.app.model.Laboratory;
import com.hsoft.app.model.PrefixSuffix;
import com.hsoft.app.model.Radiology;
import com.hsoft.app.repository.ICDCodesRepository;
import com.hsoft.app.repository.LaboratoryRepository;
import com.hsoft.app.repository.PrefixSuffixRepository;
import com.hsoft.app.repository.RadiologyRepository;
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

	/********************************************************************************************************************************
	 ************************************************** ALL THE POST MAPPINGS********************************************************
	 ********************************************************************************************************************************
	 */
	@PostMapping("/createUpdatePrefixSuffix")
	public Map<String, String> createDoctor(@RequestBody PrefixSuffix prefixSuffix) {
		Map<String, String> response = new HashMap<>();
		try {
			PrefixSuffix prefixSuffixs = prefixSuffixRepo.findByPrefixSuffix(prefixSuffix.getPrefixSuffix());
			prefixSuffixs.setPrefixSuffixValue(prefixSuffix.getPrefixSuffixValue());
			prefixSuffixRepo.save(prefixSuffixs);
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
		return laboratoryRepo.findByServiceCodeOrLabService(laboratory.getServiceCode(),laboratory.getLabService());
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


    }
