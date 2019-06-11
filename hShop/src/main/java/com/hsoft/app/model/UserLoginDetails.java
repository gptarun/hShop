package com.hsoft.app.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user_login_details")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class UserLoginDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userlogSeq")
	@SequenceGenerator(name = "userlogSeq", sequenceName = "USER_LOG_SEQ", allocationSize = 1)
	private long userLogId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "local_timestamp")
	@CreationTimestamp
	private LocalDateTime localTimestamp;

	public long getUserLogId() {
		return userLogId;
	}

	public void setUserLogId(long userLogId) {
		this.userLogId = userLogId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDateTime getLocalTimestamp() {
		return localTimestamp;
	}

	public void setLocalTimestamp(LocalDateTime localTimestamp) {
		this.localTimestamp = localTimestamp;
	}

}
