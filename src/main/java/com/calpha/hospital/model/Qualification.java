package com.calpha.hospital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Qualifications")
public class Qualification implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "qualId")
	private Integer qualId;

	private String instituteName;
	private String qualificationDate;
	private String qualificationName;
	private String certificate;

	public Qualification() {
		// TODO Auto-generated constructor stub
	}

}
