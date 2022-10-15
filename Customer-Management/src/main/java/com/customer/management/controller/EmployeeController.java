package com.customer.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.management.model.Employee;
import com.customer.management.service.EmployeeServices;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeServices employeeServices;
	

	@GetMapping("/info")
	public Employee get() {
		return employeeServices.get();

	}

	@PostMapping("/customInfo")
	public Employee getinfo(String id, String name, String email) {
		return employeeServices.getinfo(id, name, email);   
	}

}
