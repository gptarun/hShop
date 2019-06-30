package com.hsoft.app.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "operation_code")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class OperationCode {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opCodeSequence")
	@SequenceGenerator(name = "opCodeSequence", sequenceName = "OP_CODE_SEQ", allocationSize = 1)
	private long opCodeId;
	private String opCode;
	private String opCodeName;

	public long getOpCodeId() {
		return opCodeId;
	}

	public void setOpCodeId(long opCodeId) {
		this.opCodeId = opCodeId;
	}

	public String getOpCodeName() {
		return opCodeName;
	}

	public void setOpCodeName(String opCodeName) {
		this.opCodeName = opCodeName;
	}

	public String getOpCode() {
		return opCode;
	}

	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}

}
