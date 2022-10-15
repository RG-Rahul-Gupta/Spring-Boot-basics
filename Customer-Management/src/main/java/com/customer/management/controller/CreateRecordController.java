package com.customer.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.management.entity.Customer;
import com.customer.management.service.CreateRecordService;

@RestController
@RequestMapping("/CreateServices")
public class CreateRecordController {

	@Autowired
	CreateRecordService createRecord;
	
	@PostMapping("/AddRecord")
	public String addRecord(Customer customer) {
		return createRecord.addSingleRecord(customer);
	}
	
	@PostMapping("/AddRecords")
	public String addRecords(@RequestBody List<Customer> customers) {
		return createRecord.addMultipleRecords(customers);
	}
}

