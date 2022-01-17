package com.calpha.hospital.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
@DiscriminatorValue("Nurse")
public class Nurse extends Employee implements Serializable {


	private static final long serialVersionUID = 1L;

	public Nurse() {
		// TODO Auto-generated constructor stub
	}

}
