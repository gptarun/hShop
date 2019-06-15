package com.hsoft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsoft.app.model.Bed;
import com.hsoft.app.model.WardBedTab;

public interface WardBedTabRepository extends JpaRepository<WardBedTab, Long> {

	List<Bed> findByWardId(long wardId);
}
