package com.customer.management.serviceImpl;

import org.springframework.stereotype.Service;

import com.customer.management.model.Employee;
import com.customer.management.service.EmployeeServices;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServicesImpl implements EmployeeServices {

	
	public Employee get() {
		log.info("Inside get() method");
		Employee emp = new Employee();
		emp.setEmpId("1"); 
		emp.setName("Raghav Yaduvanshi");
		emp.setEmailId("raghavyadu@xmail.com");
		return emp;

	}

	public Employee getinfo(String id, String name, String email) {
		log.info("Inside getinfo() method");
		Employee emp = new Employee();
		emp.setEmpId(id);
		emp.setName(name);
		emp.setEmailId(email);
		return emp;
	}
}
