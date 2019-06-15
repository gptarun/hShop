package com.hsoft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsoft.app.model.Ward;

@Repository
public interface WardRepository extends JpaRepository<Ward, Long> {

}
