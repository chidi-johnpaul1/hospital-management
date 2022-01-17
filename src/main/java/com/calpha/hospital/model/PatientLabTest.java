/**
 * 
 */
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
@Table(name="patientTest")
public class PatientLabTest implements Serializable {
   
	private static final long serialVersionUID = 1L;

@Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 @Column(name="test_Id")              
 private Long testId;
   
 @Column(name="patientId")       
private Long patientId;
        
   
@Column(name="testName")
private String testName;
           
@Column(name="testDescription")
 private String testDescription ;
        

@Column(name="labScientistId")
private Long labScientistId;
       
@Column(name="doctorId")
private Long doctorId; 
       
@Column(name="DateTime")
@Temporal(javax.persistence.TemporalType.DATE)
private Date dateTime; 
       
@Column(name="returnDate")
@Temporal(javax.persistence.TemporalType.DATE)
private Date returnDate; 
       
@Column(name="testResult")
private String testResult; 
       
@Column(name="remark")       
private String remark;

@Column(name="testCharge")
private double testCharge ;

	public PatientLabTest() {
		// TODO Auto-generated constructor stub
	}

}
