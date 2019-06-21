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

import com.hsoft.app.constant.HShopConstant;
import com.hsoft.app.model.PrefixSuffix;
import com.hsoft.app.repository.PrefixSuffixRepository;

@CrossOrigin(origins = "*")
@RestController

public class SeedController {

	@Autowired
	PrefixSuffixRepository prefixSuffixRepo;

	/**
	 * create
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
	
	@GetMapping("/getPrefixSuffixs")
	public List<PrefixSuffix> getPrefixSuffixs() {
		return prefixSuffixRepo.findAll();
	}

}
