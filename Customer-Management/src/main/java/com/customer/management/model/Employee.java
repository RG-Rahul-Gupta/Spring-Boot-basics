package com.customer.management.model;

public class Employee {

	private String empId;
	private String name;
	private String emailId;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String empId, String name, String emailId) {
		super();
		this.empId = empId;
		this.name = name;
		this.emailId = emailId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", emailId=" + emailId + "]";
	}
	
	
	

}
