package com.calpha.hospital.model;

	import java.io.Serializable;
	import javax.persistence.DiscriminatorValue;
	import javax.persistence.Entity;
	
	import javax.persistence.Table;

	@Entity
	@Table(name = "Employee")
	@DiscriminatorValue("LabScientist")
	public class LabScientist  extends Employee implements Serializable {

		private static final long serialVersionUID = 1L;

	public LabScientist() {
		// TODO Auto-generated constructor stub
	}

}
