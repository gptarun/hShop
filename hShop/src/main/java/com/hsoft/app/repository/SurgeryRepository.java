package com.hsoft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.Surgery;

public interface SurgeryRepository extends JpaRepository<Surgery, Long> {

}
