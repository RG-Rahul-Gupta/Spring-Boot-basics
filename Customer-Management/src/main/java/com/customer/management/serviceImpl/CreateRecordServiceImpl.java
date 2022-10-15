package com.customer.management.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.management.entity.Customer;
import com.customer.management.repository.CustomerRepository;
import com.customer.management.service.CreateRecordService;


@Service
public class CreateRecordServiceImpl implements CreateRecordService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public String addSingleRecord(Customer customer) {
		customerRepository.save(customer);
		customerRepository.flush();
		return "Record Inserted";
	}
	
	@Override
	public String addMultipleRecords(List<Customer> customer) {
		customerRepository.saveAll(customer);
		customerRepository.flush();
		return "All Records Inserted";
		
	}
	
	@Override
	public Customer addSingleRecordwithSaveandFlush(Customer customer) {
		return customerRepository.saveAndFlush(customer);
	}

}
