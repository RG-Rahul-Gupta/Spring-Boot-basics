package com.customer.management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.customer.management.entity.Customer;
import com.customer.management.repository.CustomerRepository;
import com.customer.management.service.CheckExistRecordService;

@Service
public class CheckExistRecordServiceImpl implements CheckExistRecordService {
	
	@Autowired
	CustomerRepository customerRespository;
	
	@Override
	public boolean checkExistRecordById(int id) {
		return customerRespository.existsById(id);
	}
	
	@Override
	public boolean checkExistRecordByParam(String address) {
		Customer customer = new Customer();
		customer.setAddress(address);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher(address, ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","name");
		Example<Customer> example = Example.of(customer, exampleMatcher);
		return customerRespository.exists(example);
	}
	

}
