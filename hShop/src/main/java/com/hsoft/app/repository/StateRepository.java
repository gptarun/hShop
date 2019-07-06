package com.hsoft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.State;

public interface StateRepository extends JpaRepository<State,Long> {
	

}
