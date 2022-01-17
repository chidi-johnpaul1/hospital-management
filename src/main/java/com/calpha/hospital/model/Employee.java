package com.calpha.hospital.model;


import lombok.Builder;
import lombok.experimental.Tolerate;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import  java.util.Date;
import java.util.List;

import javax.persistence.Temporal;

/**
*
* @author CAlpha
*/
@Entity
@Builder
@Table(name="employee")
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @Column(name=" EmployeeId")
	   private Long employeeId;
	
	  @Column(name="surname")
	  private String surname;
	    
	  @Column(name="firstName")
	  private String firstName;
	  
	  @Column(name="lastName")
	  private String lastName;
	  
	  
	  
	  @Column(name="designnation")
	  String designation;
	  
	  @Column(name="dob")
	  @Temporal(javax.persistence.TemporalType.DATE)
	  private Date dateOfBirth;
	    
	  @Column(name="gender")
	  private String gender;
	      
	  @Column(name="maritalStatus")
	  private String maritalStatus;
	  
	  @Column(name="dateOfEmployment")
	  @Temporal(javax.persistence.TemporalType.DATE)
	  private Date dateOfEmployment;
	    
	   
	  @Column(name="address")
	  private String address;
	  
	  @Column(name="phoneNo")
	  private String phoneNo;
	    
	  @Column(name="email")
	   private String email;
	  

	  @Column(name="workingHours")
	  private String workingHours;
	    
	  @Column(name="employeeType")
	  private  String employeeType;
	  
	 @Column(name="in_patient_visiting_hours")  
	 private String inPatientVisitHours;
	     
	 @Column(name="out_patient_visiting_hours")  
	 private String outPatientVisitHours;
	    
	  @Column(name="emergencyContact")
	  private String emergencyContact;
	  
	  @OneToMany(fetch = FetchType.EAGER , targetEntity = WorkExperince.class, cascade = { CascadeType.ALL  })
		@JoinColumn(name = "employeeId")
		private List<WorkExperince> workExperinces;

		@OneToMany(fetch = FetchType.EAGER, targetEntity = Qualification.class, cascade = { CascadeType.ALL })
		@JoinColumn(name = "employeeId")
		private List<Qualification> qualifications;

	
	@Tolerate
	public Employee(){
		workExperinces=new ArrayList<>();
		qualifications=new ArrayList<>();
		
	}

	public Employee(Long employeeId, String firstName, String lastName, String surname, String designation,
			Date dateOfBirth, String gender, String maritalStatus, Date dateOfEmployment, String address,
			String phoneNo, String email, String workingHours, String employeeType, String inPatientVisitHours,
			String outPatientVisitHours, String emergencyContact, List<WorkExperince> workExperinces,
			List<Qualification> qualifications, String name, Integer salary, Float commission) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.surname = surname;
		this.designation = designation;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.dateOfEmployment = dateOfEmployment;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.workingHours = workingHours;
		this.employeeType = employeeType;
		this.inPatientVisitHours = inPatientVisitHours;
		this.outPatientVisitHours = outPatientVisitHours;
		this.emergencyContact = emergencyContact;
		this.workExperinces = workExperinces;
		this.qualifications = qualifications;
			}

	/**
	 * @return the employeeId
	 */
	public Long getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param othername the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
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
	 * @return the dateOfEmployment
	 */
	public Date getDateOfEmployment() {
		return dateOfEmployment;
	}

	/**
	 * @param dateOfEmployment the dateOfEmployment to set
	 */
	public void setDateOfEmployment(Date dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
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
	 * @return the workingHours
	 */
	public String getWorkingHours() {
		return workingHours;
	}

	/**
	 * @param workingHours the workingHours to set
	 */
	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}

	/**
	 * @return the employeeType
	 */
	public String getEmployeeType() {
		return employeeType;
	}

	/**
	 * @param employeeType the employeeType to set
	 */
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	/**
	 * @return the inPatientVisitHours
	 */
	public String getInPatientVisitHours() {
		return inPatientVisitHours;
	}

	/**
	 * @param inPatientVisitHours the inPatientVisitHours to set
	 */
	public void setInPatientVisitHours(String inPatientVisitHours) {
		this.inPatientVisitHours = inPatientVisitHours;
	}

	/**
	 * @return the outPatientVisitHours
	 */
	public String getOutPatientVisitHours() {
		return outPatientVisitHours;
	}

	/**
	 * @param outPatientVisitHours the outPatientVisitHours to set
	 */
	public void setOutPatientVisitHours(String outPatientVisitHours) {
		this.outPatientVisitHours = outPatientVisitHours;
	}

	/**
	 * @return the emergencyContact
	 */
	public String getEmergencyContact() {
		return emergencyContact;
	}

	/**
	 * @param emergencyContact the emergencyContact to set
	 */
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	/**
	 * @return the workExperinces
	 */
	public List<WorkExperince> getWorkExperinces() {
		return workExperinces;
	}

	/**
	 * @param workExperinces the workExperinces to set
	 */
	public void setWorkExperinces(List<WorkExperince> workExperinces) {
		this.workExperinces = workExperinces;
	}

	/**
	 * @return the qualifications
	 */
	public List<Qualification> getQualifications() {
		return qualifications;
	}

	/**
	 * @param qualifications the qualifications to set
	 */
	public void setQualifications(List<Qualification> qualifications) {
		this.qualifications = qualifications;
	}

	
	
}