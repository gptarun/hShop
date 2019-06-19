package com.hsoft.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	@PostMapping("/createPrefixSuffix")
	public Map<String, String> createDoctor(@RequestBody PrefixSuffix prefixSuffix) {
		Map<String, String> response = new HashMap<>();
		try {
			PrefixSuffix prefixSuffixs=prefixSuffixRepo.findByPrefixSuffixAndPrefixSuffixValue(prefixSuffix.getPrefixSuffix(), prefixSuffix.getPrefixSuffixValue());
			if(prefixSuffixs==null) {
			prefixSuffixRepo.save(prefixSuffix);
			response.put(HShopConstant.STATUS, HShopConstant.TRUE);
			response.put(HShopConstant.MESSAGE, "PrefixSuffix has been created");
			return response;
			}
			else
			{
				response.put(HShopConstant.STATUS, HShopConstant.TRUE);
				response.put(HShopConstant.MESSAGE, "PrefixSuffix has been created");
				return response;
			}
			
		} catch (Exception e) {
			response.put(HShopConstant.STATUS, HShopConstant.FALSE);
			response.put(HShopConstant.MESSAGE, e.toString());
			return response;
		}
	}

	
	@PostMapping("/getPrefixSuffix")
	public PrefixSuffix getPrefixSuffix(@RequestBody PrefixSuffix prefixSuffix) {
		return prefixSuffixRepo.findByPrefixSuffixId(prefixSuffix.getPrefixSuffixId());
	}

}
