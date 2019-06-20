package com.hsoft.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "plan", uniqueConstraints = { @UniqueConstraint(columnNames = "plan_type") })
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Plan {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "planSequence")
	@Column(name = "plan_id", updatable = false, nullable = false)
	private long planId;
	
	@Column(name = "plan_type")
	private String planType;
	
	@Column(name = "discount_percentage")
	private double discountPercentage;	
	
}
