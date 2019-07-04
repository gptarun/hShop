package com.hsoft.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hsoft.app.model.GlobalSettings;

public interface GlobalSettingsRepository extends JpaRepository<GlobalSettings,Long> {
    
	@Modifying
	@Transactional
	@Query(value=" delete from global_settings where global_setting_id = :globalSettingId", nativeQuery = true)
	void deleteGlobalSettings(@Param("globalSettingId") long globalSettingId);

	GlobalSettings findByLocationName(String locationName);
	}
