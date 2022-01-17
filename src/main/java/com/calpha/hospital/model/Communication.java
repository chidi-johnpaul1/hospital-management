package com.calpha.hospital.model;


	import java.sql.Date;

import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.OneToOne;
	import javax.persistence.Table;
	import javax.persistence.Temporal;

	@Entity
	@Table(name = "Communications")
	public class Communication implements java.io.Serializable {

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "communicationId")
		private Integer communicationId;

		private String messageBody;

		private String subject;

		private boolean messageStatus;

		@Temporal(javax.persistence.TemporalType.DATE)
		private Date messageDate;

		@OneToOne(fetch = FetchType.EAGER, targetEntity = Employee.class, cascade = { CascadeType.ALL, CascadeType.REMOVE })
		@JoinColumn(name = "from_employeeId")
		private Employee fromEmployee;

		@OneToOne(fetch = FetchType.EAGER, targetEntity = Employee.class, cascade = { CascadeType.ALL, CascadeType.REMOVE })
		@JoinColumn(name = "fto_employeeId")
		private Employee toEmployee;

		@OneToOne(fetch = FetchType.EAGER, targetEntity = Patient.class, cascade = { CascadeType.ALL, CascadeType.REMOVE })
		@JoinColumn(name = "patientId")
		private Patient patient;

	public Communication() {
		// TODO Auto-generated constructor stub
	}

}
