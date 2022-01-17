package com.calpha.hospital.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;

/**
*
* @author CAlpha
*/
@Builder
@Entity
@Table(name="bed")
public class Bed implements Serializable {
   
	private static final long serialVersionUID = 1L;

@Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="bed_id ")
    private Long bedId;

	@Column(name="patient_id ")
	private Long patientId;
           
   @Column(name="bed_code")
    private String bedCode;
   
   @Column(name="status")
    private String bedStatus;
}