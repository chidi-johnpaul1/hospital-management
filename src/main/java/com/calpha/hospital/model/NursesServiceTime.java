package com.calpha.hospital.model;


	import java.io.Serializable;
	import java.util.Date;

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

	@Entity
	@Table(name = "NursesServiceTimes")
	public class NursesServiceTime implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "nurseServiceTimeID")
		private int nurseServiceTimeID;
		
		private Date serviceDate;
		
		@OneToOne(fetch = FetchType.EAGER,targetEntity = TimeSchedule.class, cascade = {CascadeType.ALL})
		@JoinColumn(name = "timeScheduleId")
		private TimeSchedule timeSchedule;
		
		@OneToOne(fetch = FetchType.EAGER,targetEntity = Nurse.class, cascade = {CascadeType.ALL})
		@JoinColumn(name = "nurseId")
		private Nurse nurse;
		
		
		private String department;
	public NursesServiceTime() {
		// TODO Auto-generated constructor stub
	}

}
