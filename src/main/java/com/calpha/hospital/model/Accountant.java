package com.calpha.hospital.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Employee"  )
@DiscriminatorValue("Accountant")
public class Accountant extends Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	public Accountant() {
		// TODO Auto-generated constructor stub
	}

}
