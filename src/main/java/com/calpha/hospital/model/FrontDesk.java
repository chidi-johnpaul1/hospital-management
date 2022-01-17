package com.calpha.hospital.model;


	import java.io.Serializable;
	import javax.persistence.DiscriminatorValue;
	import javax.persistence.Entity;
	import javax.persistence.Table;

	@Entity
	@Table(name = "Employee")
	@DiscriminatorValue("FrontDesk")
	public class FrontDesk  extends Employee implements Serializable {

		private static final long serialVersionUID = 1L;

	public FrontDesk() {
		// TODO Auto-generated constructor stub
	}

}
