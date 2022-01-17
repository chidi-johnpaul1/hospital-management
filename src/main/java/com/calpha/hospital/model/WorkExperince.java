package com.calpha.hospital.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "WorkExperince")
public class WorkExperince implements java.io.Serializable {


	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "workExperienceId")
		private Long workExperienceId;
		
		@Column(name = "employeeId")
		private Integer employeeId;
		
		@Column(name = "nameOfOrganization")
		private String nameOfOrganization;
		
		@Column(name = "position")
		private String position;
		
		@Column(name = "endDate")
		private String endDate;
		
		@Column(name = "startDate")
		private String startDate;

	public WorkExperince() {
		// TODO Auto-generated constructor stub
	}

}
