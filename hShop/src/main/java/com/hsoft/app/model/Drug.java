package com.hsoft.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Accordify Solutions
 *
 */
@Entity
@Table(name = "Drug")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Drug {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drugSequence")
	@SequenceGenerator(name = "drugSequence", sequenceName = "DRUG_SEQ", allocationSize = 1)
	private long drugId;
	private String genericName;
	private String classification;
	private String formulation;
	private double costPrice;
	private double generalPrice;
	private double nHISPrice;
	private double markup;
	private String brandName;
	private String strength;
	private Date startDate;
	private Date endDate;
	private int unitsPk;
	private int pkPacket;

	public long getDrugId() {
		return drugId;
	}

	public void setDrugId(long drugId) {
		this.drugId = drugId;
	}

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getFormulation() {
		return formulation;
	}

	public void setFormulation(String formulation) {
		this.formulation = formulation;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getGeneralPrice() {
		return generalPrice;
	}

	public void setGeneralPrice(double generalPrice) {
		this.generalPrice = generalPrice;
	}

	public double getnHISPrice() {
		return nHISPrice;
	}

	public void setnHISPrice(double nHISPrice) {
		this.nHISPrice = nHISPrice;
	}

	public double getMarkup() {
		return markup;
	}

	public void setMarkup(double markup) {
		this.markup = markup;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getUnitsPk() {
		return unitsPk;
	}

	public void setUnitsPk(int unitsPk) {
		this.unitsPk = unitsPk;
	}

	public int getPkPacket() {
		return pkPacket;
	}

	public void setPkPacket(int pkPacket) {
		this.pkPacket = pkPacket;
	}

}
