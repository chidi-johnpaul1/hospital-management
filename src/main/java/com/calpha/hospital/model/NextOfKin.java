package com.calpha.hospital.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*
* @author CAlpha
*/
@Entity
@Table(name="nextOfKin")
public class NextOfKin implements Serializable {
   
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   
   @Column(name="nextOfKinId")
   Long nextOfKinId;
   
   
   @Column(name="patientId")
   Long patientId; 
   
   @Column(name="employeeId")   
   Long employeeId;
   
   
   @Column(name="nextOfKinName")
   String nextOfKinName;
   
   @Column(name="nextOfKinAddress")
   String nextOfKinAddress;
   
   @Column(name="nextOfKinPhoneNo")
   String nextOfKinPhoneNo;
}
