package com.customer.management.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.management.entity.Customer;
import com.customer.management.repository.CustomerRepository;
import com.customer.management.service.DeleteRecordService;

@Service
public class DeleteRecordServiceImpl implements DeleteRecordService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public String deleteSingleRecord(Customer customer) {
		customerRepository.delete(customer);
		String deletedRecord="Record Deleted :"+customer+"1";
		return deletedRecord;
	}
	
	@Override
	public String deleteAllRecords() {
		customerRepository.deleteAll();
		return "All records Deleted";
	}
	
	@Override
	public String deleteMultipleRecords(List<Customer> customer) {
       customerRepository.deleteAll(customer);
       return "Multiple Records Delted";
	}
	
}
