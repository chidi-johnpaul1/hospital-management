package com.calpha.hospital.model;

import lombok.Builder;
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
//import javax.persistence.Temporal;
//import  java.util.Date;
@Builder
@Entity
@Table(name="lab_test")
public class LabTest implements Serializable {

	private static final long serialVersionUID = 1L;

@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="lab_id")
     Long labTestId;
    
    @Column(name="test_name")
    String testName;
     
    @Column(name="description")
    String testDescription;
    
    @Column(name="amount")
    double testPrice;
    
	public LabTest() {
		// TODO Auto-generated constructor stub
	}

}
