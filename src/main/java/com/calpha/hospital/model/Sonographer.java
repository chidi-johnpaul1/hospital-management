package com.calpha.hospital.model;


	import java.io.Serializable;
	
	import javax.persistence.DiscriminatorValue;
	import javax.persistence.Entity;
	import javax.persistence.Table;

	@Entity
	@Table(name = "Employee")
	@DiscriminatorValue("Sonographer")
	public class Sonographer  extends Employee implements Serializable {
	
		private static final long serialVersionUID = 1L;

	public Sonographer() {
		// TODO Auto-generated constructor stub
	}

}
