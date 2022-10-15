package com.customer.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.management.entity.Customer;
import com.customer.management.service.DeleteRecordService;

@RestController
@RequestMapping("/DeleteServices")
public class DeleteRecordController {
	
	@Autowired
	DeleteRecordService deleteRecord;
	
	@DeleteMapping("/DeleteRecord")
	public String deleteSingleRecord(Customer customer) {
		return deleteRecord.deleteSingleRecord(customer);
	}
	
	@DeleteMapping("/DeleteAllRecords")
	public String deleteAllRecords() {
		return deleteRecord.deleteAllRecords();
	}
	
	@DeleteMapping("/DeleteRecords")
	public String deleteMultipleRecords(@RequestBody List<Customer> customers) {
		return deleteRecord.deleteMultipleRecords(customers);
	}
	

}
