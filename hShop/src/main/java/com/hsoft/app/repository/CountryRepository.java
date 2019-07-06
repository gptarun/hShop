package com.hsoft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
