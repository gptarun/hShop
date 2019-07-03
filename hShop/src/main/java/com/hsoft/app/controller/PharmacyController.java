package com.hsoft.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsoft.app.bean.ResponseModel;
import com.hsoft.app.constant.HShopConstant;
import com.hsoft.app.model.Drug;
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
}
