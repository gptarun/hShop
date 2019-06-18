package com.hsoft.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "patient")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patientSequence")
	@SequenceGenerator(name = "patientSequence", sequenceName = "PATIENT_SEQ", allocationSize = 1)
	private long patientId;

	private String patientNumber;

	private String patientCategory;
	private int clinicId;
	
	private String firstName;
	private String lastName;
	private String maritalStatus;
	private String gender;
	private String religion;
	private String ethnicGroup;
	private Date dob;
	private int age;

	private String idType;
	private String idNumber;
	private Date expiryDate;

	private int phoneNumber;
	private String email;
	private String address;
	private String nationality;
	private String state;

	private String nokName;
	private String nokRelationship;
	private int nokPhoneNumber;
	private String nokAddress;

	private String cardHolderName;
	private String insuranceNumber;
	private Date cardExpiry;

	private String insuranceName;
	private String schemePlan;
	private double discount;

	private String transferredFrom;
	private Date dateOfTransfer;
	private String hospitalAddress;
	private String authorizeDoctorName;
	private String transferReason;

	private boolean telephone;
	private boolean internet;
	private boolean electricity;
	private boolean cleanWater;
	private boolean localityHostile;
	private String highestEducation;
	private String occupation;
	private String accommodationType;

	@ManyToOne
	@JoinColumn(name = "ward_id")
	private Ward ward;
	
	public Ward getWard() {
		return ward;
	}

	public void setWard(Ward ward) {
		this.ward = ward;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getPatientCategory() {
		return patientCategory;
	}

	public void setPatientCategory(String patientCategory) {
		this.patientCategory = patientCategory;
	}

	public int getClinicId() {
		return clinicId;
	}

	public void setClinicId(int clinicId) {
		this.clinicId = clinicId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getEthnicGroup() {
		return ethnicGroup;
	}

	public void setEthnicGroup(String ethnicGroup) {
		this.ethnicGroup = ethnicGroup;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNokName() {
		return nokName;
	}

	public void setNokName(String nokName) {
		this.nokName = nokName;
	}

	public String getNokRelationship() {
		return nokRelationship;
	}

	public void setNokRelationship(String nokRelationship) {
		this.nokRelationship = nokRelationship;
	}

	public int getNokPhoneNumber() {
		return nokPhoneNumber;
	}

	public void setNokPhoneNumber(int nokPhoneNumber) {
		this.nokPhoneNumber = nokPhoneNumber;
	}

	public String getNokAddress() {
		return nokAddress;
	}

	public void setNokAddress(String nokAddress) {
		this.nokAddress = nokAddress;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getInsuranceNumber() {
		return insuranceNumber;
	}

	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

	public Date getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(Date cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public String getSchemePlan() {
		return schemePlan;
	}

	public void setSchemePlan(String schemePlan) {
		this.schemePlan = schemePlan;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getTransferredFrom() {
		return transferredFrom;
	}

	public void setTransferredFrom(String transferredFrom) {
		this.transferredFrom = transferredFrom;
	}

	public Date getDateOfTransfer() {
		return dateOfTransfer;
	}

	public void setDateOfTransfer(Date dateOfTransfer) {
		this.dateOfTransfer = dateOfTransfer;
	}

	public String getHospitalAddress() {
		return hospitalAddress;
	}

	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}

	public String getAuthorizeDoctorName() {
		return authorizeDoctorName;
	}

	public void setAuthorizeDoctorName(String authorizeDoctorName) {
		this.authorizeDoctorName = authorizeDoctorName;
	}

	public String getTransferReason() {
		return transferReason;
	}

	public void setTransferReason(String transferReason) {
		this.transferReason = transferReason;
	}

	public boolean isTelephone() {
		return telephone;
	}

	public void setTelephone(boolean telephone) {
		this.telephone = telephone;
	}

	public boolean isInternet() {
		return internet;
	}

	public void setInternet(boolean internet) {
		this.internet = internet;
	}

	public boolean isElectricity() {
		return electricity;
	}

	public void setElectricity(boolean electricity) {
		this.electricity = electricity;
	}

	public boolean isCleanWater() {
		return cleanWater;
	}

	public void setCleanWater(boolean cleanWater) {
		this.cleanWater = cleanWater;
	}

	public boolean isLocalityHostile() {
		return localityHostile;
	}

	public void setLocalityHostile(boolean localityHostile) {
		this.localityHostile = localityHostile;
	}

	public String getHighestEducation() {
		return highestEducation;
	}

	public void setHighestEducation(String highestEducation) {
		this.highestEducation = highestEducation;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getAccommodationType() {
		return accommodationType;
	}

	public void setAccommodationType(String accommodationType) {
		this.accommodationType = accommodationType;
	}

	public String getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}

}
