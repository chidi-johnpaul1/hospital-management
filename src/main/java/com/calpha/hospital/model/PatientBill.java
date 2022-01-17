package com.calpha.hospital.model;

/**
*
* @author CAlpha
*/

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

@Builder
@Entity
@Table(name="patient_bill")
public class PatientBill implements Serializable {

	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY) 
@Column(name="bil_id")
private Long PatientBillId;
 
@Column(name="patientId")
private Long patientId ;

@Column(name="billDate")
 @Temporal(javax.persistence.TemporalType.DATE)
private Date billDate ;

@Column(name="doctorCharge")
private double doctorCharge; 

@Column(name="drugCharge")
private double drugCharge;

@Column(name="operationCharge")
private double operationCharge;

@Column(name="roomCharge")
private double roomCharge;
       
@Column(name="nursingCharge")
private double nursingCharge;  
       
@Column(name="labCharge")       
private double labCharge;
       
@Column(name="noOfDays")
private int noOfDays;

@Column(name="otherCharges")       
private double otherCharges;
       
@Column(name="advancePayment")        
private double advancePayment;
       
@Column(name="healthCard")
private String healthCard;
       
@Column(name="totalBill")
private double totalBill; 

	public PatientBill() {
		// TODO Auto-generated constructor stub
	}

}
