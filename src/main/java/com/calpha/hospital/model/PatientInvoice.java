package com.calpha.hospital.model;

import java.sql.Date;

public class PatientInvoice {

	private Long drugId;
	private Long labTestId;
	private double labCost;
	private double drugCost;
	
	private String drugName;
	private String testName;
	private int quantity;
	private String unitPerDay;
	
	private Date startDate;
	private Date drugExpiredDate;
	
	private double totalCost;
	private String patientName;

	public PatientInvoice() {
		// TODO Auto-generated constructor stub
	}

}
