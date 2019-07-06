package com.hsoft.app.model;

import javax.persistence.Column;
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
	private String clinicName;

	private String firstName;
	private String lastName;
	private String maritalStatus;
	private String gender;
	private String religion;
	private String ethnicGroup;
	private String dob;
	private double age;

	private String idType;
	private String idNumber;
	private String expiryDate;

	private String phoneNumber;
	private String email;
	private String address;
	private String nationality;
	private String state;

	private String nokName;
	private String nokRelationship;
	private String nokPhoneNumber;
	private String nokAddress;

	// To add medical informations like dependent, number, place of work etc
	private String holderDependant;
	private String cardNumber;
	private String referalNumber;
	private String referalDate;
	private String cardHolderName;
	private String placeOfWork;
	private String department;

	// Scheme details
	private String schemeName;
	private String schemePlan;
	private double discount;
	private String primaryProvider;
	private String typeOfCare;
	private String diagnosis;
	private String approvalCode;
	private String approvalCodeStart;
	private String approvalCodeEnd;

	private String transferredFrom;
	private String dateOfTransfer;
	private String hospitalAddress;
	private String authorizeDoctorName;
	private String transferReason;

	private boolean isAttended;

	private boolean telephone;
	private boolean internet;
	private boolean electricity;
	private boolean cleanWater;
	private boolean localityHostile;
	private String highestEducation;
	private String occupation;
	private String accommodationType;
	@Column(name = "encoded_image", length = 10000)
	private String encodedImage;

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
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

	public String getNokPhoneNumber() {
		return nokPhoneNumber;
	}

	public void setNokPhoneNumber(String nokPhoneNumber) {
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

	public String getEncodedImage() {
		return encodedImage;
	}

	public void setEncodedImage(String encodedImage) {
		this.encodedImage = encodedImage;
	}

	public boolean isAttended() {
		return isAttended;
	}

	public void setAttended(boolean isAttended) {
		this.isAttended = isAttended;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getHolderDependant() {
		return holderDependant;
	}

	public void setHolderDependant(String holderDependant) {
		this.holderDependant = holderDependant;
	}

	public String getDateOfTransfer() {
		return dateOfTransfer;
	}

	public void setDateOfTransfer(String dateOfTransfer) {
		this.dateOfTransfer = dateOfTransfer;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getReferalNumber() {
		return referalNumber;
	}

	public void setReferalNumber(String referalNumber) {
		this.referalNumber = referalNumber;
	}

	public String getReferalDate() {
		return referalDate;
	}

	public void setReferalDate(String referalDate) {
		this.referalDate = referalDate;
	}

	public String getPlaceOfWork() {
		return placeOfWork;
	}

	public void setPlaceOfWork(String placeOfWork) {
		this.placeOfWork = placeOfWork;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getPrimaryProvider() {
		return primaryProvider;
	}

	public void setPrimaryProvider(String primaryProvider) {
		this.primaryProvider = primaryProvider;
	}

	public String getTypeOfCare() {
		return typeOfCare;
	}

	public void setTypeOfCare(String typeOfCare) {
		this.typeOfCare = typeOfCare;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getApprovalCode() {
		return approvalCode;
	}

	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}

	public String getApprovalCodeStart() {
		return approvalCodeStart;
	}

	public void setApprovalCodeStart(String approvalCodeStart) {
		this.approvalCodeStart = approvalCodeStart;
	}

	public String getApprovalCodeEnd() {
		return approvalCodeEnd;
	}

	public void setApprovalCodeEnd(String approvalCodeEnd) {
		this.approvalCodeEnd = approvalCodeEnd;
	}
}
