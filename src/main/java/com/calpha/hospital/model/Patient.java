package com.calpha.hospital.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

import lombok.Builder;

import  java.util.Date;

/**
*
* @author CAlpha
*/
@Builder
@Entity
@Table(name="patient")
public class Patient implements  Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="patient_id")
    private Long patientId ;
  
    @Column(name="pasport")
    private byte[] passport;
    
    @Column(name="first_name")
     private String firstName;
    
    @Column(name="lastname")
     private String lastName;
    
    private String name;
    
     @Column(name="other_name")
     private String otherName;
     
     @Column(name="age")
     private int age;
       
     @Column(name="DOB")
    @Temporal(javax.persistence.TemporalType.DATE)
     private Date dateOfBirth;
    
     @Column(name="gender")
     private String gender;
      
     @Column(name="marital_status")
     private String maritalStatus;
      
     @Column(name="home_address")
     private String homeAddress;
      
    @Column(name="contact_address")
     private String contactAddress;
    
    @Column(name="phone_no")
     private String phoneNo;
    
    @Column(name="email")
     private String email;
    
    @Column(name="next_of_kin")
     private String nextOfKin;
    
    @Column(name="LGA")
     private String LGA;
    
    @Column(name="state_of_origin")
     private String stateOfOrigin;
    
    @Column(name="nationality")
     private String nationality;
    
    @Column(name="symptons_sickness")
     private String symptonsSickness;
    
     @Column(name="patient_type")
     private String patientType;
    
     @Column(name="time_of_registration")
    @Temporal(javax.persistence.TemporalType.DATE)
     private Date timeOfRegistration;
    
    @Column(name="Attended_by")
     private String attendedBy;

	/**
	 * @return the patientId
	 */
	public Long getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the passport
	 */
	public byte[] getPassport() {
		return passport;
	}

	/**
	 * @param passport the passport to set
	 */
	public void setPassport(byte[] passport) {
		this.passport = passport;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the otherName
	 */
	public String getOtherName() {
		return otherName;
	}

	/**
	 * @param otherName the otherName to set
	 */
	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the maritalStatus
	 */
	public String getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * @param maritalStatus the maritalStatus to set
	 */
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * @return the homeAddress
	 */
	public String getHomeAddress() {
		return homeAddress;
	}

	/**
	 * @param homeAddress the homeAddress to set
	 */
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	/**
	 * @return the contactAddress
	 */
	public String getContactAddress() {
		return contactAddress;
	}

	/**
	 * @param contactAddress the contactAddress to set
	 */
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the nextOfKin
	 */
	public String getNextOfKin() {
		return nextOfKin;
	}

	/**
	 * @param nextOfKin the nextOfKin to set
	 */
	public void setNextOfKin(String nextOfKin) {
		this.nextOfKin = nextOfKin;
	}

	/**
	 * @return the lGA
	 */
	public String getLGA() {
		return LGA;
	}

	/**
	 * @param lGA the lGA to set
	 */
	public void setLGA(String lGA) {
		LGA = lGA;
	}

	/**
	 * @return the stateOfOrigin
	 */
	public String getStateOfOrigin() {
		return stateOfOrigin;
	}

	/**
	 * @param stateOfOrigin the stateOfOrigin to set
	 */
	public void setStateOfOrigin(String stateOfOrigin) {
		this.stateOfOrigin = stateOfOrigin;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the symptonsSickness
	 */
	public String getSymptonsSickness() {
		return symptonsSickness;
	}

	/**
	 * @param symptonsSickness the symptonsSickness to set
	 */
	public void setSymptonsSickness(String symptonsSickness) {
		this.symptonsSickness = symptonsSickness;
	}

	/**
	 * @return the patientType
	 */
	public String getPatientType() {
		return patientType;
	}

	/**
	 * @param patientType the patientType to set
	 */
	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}

	/**
	 * @return the timeOfRegistration
	 */
	public Date getTimeOfRegistration() {
		return timeOfRegistration;
	}

	/**
	 * @param timeOfRegistration the timeOfRegistration to set
	 */
	public void setTimeOfRegistration(Date timeOfRegistration) {
		this.timeOfRegistration = timeOfRegistration;
	}

	/**
	 * @return the attendedBy
	 */
	public String getAttendedBy() {
		return attendedBy;
	}

	/**
	 * @param attendedBy the attendedBy to set
	 */
	public void setAttendedBy(String attendedBy) {
		this.attendedBy = attendedBy;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return firstName+" "+lastName;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}