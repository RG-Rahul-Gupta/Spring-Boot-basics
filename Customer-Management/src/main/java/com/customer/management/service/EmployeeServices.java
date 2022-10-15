package com.customer.management.service;

import org.springframework.stereotype.Component;

import com.customer.management.model.Employee;

@Component
public interface EmployeeServices {
	
	public Employee get() ;
	public Employee getinfo(String id, String name, String email) ;
	
}
