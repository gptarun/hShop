package com.hsoft.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsoft.app.model.TransactionLog;

@Repository
public interface TransactionLogRepository extends JpaRepository<TransactionLog, Long> {
	List<TransactionLog> findAll();
}
