package com.calpha.hospital.model;

/**
*
* @author CAlpha
*/

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

import lombok.Builder;

   @Builder
   @Entity
   @Table(name="patient_drugs")
public class PatientDrugs implements Serializable {    
 
	private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="patientDrugsId")
   Long patientDrugsId;
   
   @Column(name="drugId")   
   Long drugId;
   
   @Column(name="patientId")
   Long patientId;
   
   @Column(name="drugName")
   String drugName;
   
   @Column(name="quantity")           
   Long quantity;
   
   @Column(name="dateGiven")
   @Temporal(javax.persistence.TemporalType.DATE)
   Date dateGiven;
	public PatientDrugs() {
		// TODO Auto-generated constructor stub
	}

}
