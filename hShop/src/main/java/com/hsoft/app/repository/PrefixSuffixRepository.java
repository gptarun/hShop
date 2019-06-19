package com.hsoft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.PrefixSuffix;

public interface PrefixSuffixRepository extends JpaRepository<PrefixSuffix, Long>  {
	
	PrefixSuffix findByPrefixSuffixId(long id);
	PrefixSuffix findByPrefixSuffixAndPrefixSuffixValue(String prefixSuffix, String prefixSuffixValue);
	
	//@Query(value ="select * from prefix_suffix", nativeQuery = true)
	 
}
