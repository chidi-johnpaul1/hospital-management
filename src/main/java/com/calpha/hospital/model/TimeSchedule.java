package com.calpha.hospital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TimeSchedules")
public class TimeSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "timeScheduleId")
	private long timeScheduleId;

	private String fromTime;

	private String toTime;
	public TimeSchedule() {
		// TODO Auto-generated constructor stub
	}

}
