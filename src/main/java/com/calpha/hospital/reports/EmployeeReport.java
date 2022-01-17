package com.calpha.hospital.reports;

import java.util.ArrayList;
import java.util.List;

import com.calpha.hospital.model.Employee;

import net.sf.jasperreports.engine.JasperPrint;

public class EmployeeReport {
	private List<Employee> employeeList = new ArrayList<>();

	public EmployeeReport(List<Employee> employeeList) {
		// TODO Auto-generated constructor stub
		this.employeeList = employeeList;
	}

	public JasperPrint getReport() {
		// TODO Auto-generated method stub
		return null;
	}

}
