package com.hsoft.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "transaction_logs", uniqueConstraints = { @UniqueConstraint(columnNames = "TRANSACTION_LOG_ID") })
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class TransactionLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactionLogSequence")
	@SequenceGenerator(name = "transactionLogSequence", sequenceName = "TRANSACTION_LOG_SEQ", allocationSize = 1)
	@Column(name = "TRANSACTION_LOG_ID")
	private long transactionLogId;

	@Column(name = "username")
	private String userName;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "log_date")
	private Date logDate;

	public long getTransactionLogId() {
		return transactionLogId;
	}

	public void setTransactionLogId(long transactionLogId) {
		this.transactionLogId = transactionLogId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
	
}
