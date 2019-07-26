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
import com.hsoft.app.model.Drug;
import com.hsoft.app.model.DrugClassification;
import com.hsoft.app.model.DrugFormulation;
import com.hsoft.app.repository.DrugClassificationRepository;
import com.hsoft.app.repository.DrugFormulationRepository;
import com.hsoft.app.repository.DrugRepository;

/**
 * 
 * @author Accordify Solutions
 *
 */
@CrossOrigin(origins = "*")
@RestController

public class PharmacyController {

	@Autowired
	DrugRepository drugRepo;
	
	@Autowired
	DrugClassificationRepository drugCRepo;
	
	@Autowired 
	DrugFormulationRepository drugFRepo;

	/*
	 * @Autowired PatientDrugRepository patientDrugRepo;
	 */

	/********************************************************************************************************************************
	 ************************************************** ALL THE POST MAPPINGS********************************************************
	 ********************************************************************************************************************************
	 */
	@PostMapping("/createUpdateDrug")
	public ResponseModel createUpdateDrug(@RequestBody Drug drug) {
		ResponseModel response = new ResponseModel();
		try {
			drugRepo.save(drug);
			response.setStatus(HShopConstant.TRUE);
			response.setMessage("Drug has been added");
			return response;
		} catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			response.setData(null);
			return response;
		}
	}

	@PostMapping("/findDrugByFilters")
	public ResponseModel findDrugByFilters(@RequestBody Drug drug) {
		ResponseModel response = new ResponseModel();
		try {
			response.setData(drugRepo.findByLikeCriteria(drug.getBrandName(), drug.getStartDate(), drug.getEndDate(),
					drug.getClassification(), drug.getFormulation()));
			response.setStatus(HShopConstant.TRUE);
			response.setMessage("Drugs has been found");
			return response;
		} catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			response.setData(null);
			return response;
		}
	}
	
	@PostMapping("/deleteDrug")
	public ResponseModel deleteDrug(@RequestBody List<Drug> drugs ) {
		ResponseModel response = new ResponseModel();
		try {
			for (Drug drug : drugs) {
				drugRepo.deleteDrug(drug.getDrugId());
			}
			response.setStatus(HShopConstant.TRUE);
			response.setMessage("All Drugs has been deleted");
			return response;
		} catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			return response;
		}
	}
	
	@PostMapping("/createUpdateDrugClassification")
	public ResponseModel createUpdateDrugClassification(@RequestBody DrugClassification drugClassification) {
		ResponseModel response = new ResponseModel();
		try {
			drugCRepo.save(drugClassification);
			response.setStatus(HShopConstant.TRUE);
			response.setMessage("Drug Classification has been added");
			return response;
		} catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			response.setData(null);
			return response;
		}
	}
	
	@PostMapping("/createUpdateDrugFormulation")
	public ResponseModel createUpdateDrugFormulation(@RequestBody DrugFormulation drugFormulation) {
		ResponseModel response = new ResponseModel();
		try {
			drugFRepo.save(drugFormulation);
			response.setStatus(HShopConstant.TRUE);
			response.setMessage("Drug formulation has been added");
			return response;
		} catch (Exception e) {
			response.setStatus(HShopConstant.FALSE);
			response.setMessage(e.toString());
			response.setData(null);
			return response;
		}
	}

	/*
	 * @PostMapping("/PatientDrugMapping") public ResponseModel
	 * PatientDrugMapping(@RequestBody PatientDrug patientdrug) { ResponseModel
	 * response = new ResponseModel(); try { patientDrugRepo.save(patientdrug);
	 * response.setStatus(HShopConstant.TRUE);
	 * response.setMessage("Drugs has been mapped"); return response; } catch
	 * (Exception e) { response.setStatus(HShopConstant.FALSE);
	 * response.setMessage(e.toString()); response.setData(null); return response; }
	 * 
	 * }
	 */

	/********************************************************************************************************************************
	 ************************************************** ALL THE GET MAPPINGS*********************************************************
	 ********************************************************************************************************************************
	 */

	@GetMapping("/getAllDrugs")
	public ResponseModel getAllDrugs() {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setStatus(HShopConstant.TRUE);
		responseModel.setMessage("All drugs found");
		responseModel.setData(drugRepo.findAll());
		return responseModel;
	}
	
	@GetMapping("/getAllDrugClassification")
	public ResponseModel getAllDrugClassification() {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setStatus(HShopConstant.TRUE);
		responseModel.setMessage("All drugs classification found");
		responseModel.setData(drugCRepo.findAll());
		return responseModel;
	}
	
	@GetMapping("/getAllDrugFormulation")
	public ResponseModel getAllDrugFormulation() {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setStatus(HShopConstant.TRUE);
		responseModel.setMessage("All drugs Formulation found");
		responseModel.setData(drugFRepo.findAll());
		return responseModel;
	}
}
