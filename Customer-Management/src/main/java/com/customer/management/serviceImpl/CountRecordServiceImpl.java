package com.customer.management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.customer.management.entity.Customer;
import com.customer.management.repository.CustomerRepository;
import com.customer.management.service.CountRecordService;

@Service 
public class CountRecordServiceImpl implements CountRecordService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public long countRecords() {
		return customerRepository.count();
	}
	
	@Override
	public long countRecordswithParam() {
		Customer customer = new Customer();
		customer.setAddress("");
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("address", ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","name");
		Example<Customer> example = Example.of(customer, exampleMatcher);
		return customerRepository.count(example);
	}
	
	
}
