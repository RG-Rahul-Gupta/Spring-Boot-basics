package com.customer.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.management.service.CountRecordService;

@RestController
@RequestMapping("/CountServices")
public class CountRecordController { 
	
	@Autowired
	CountRecordService countRecord;
	
	@GetMapping("/CountRecords")
	public long countRecords() {
		return countRecord.countRecords();
	}
	
	@GetMapping("/CountEmptyRecords")
	public long countEmptyRecords() {
		return countRecord.countRecordswithParam();
	}

}
