package com.customer.management.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.customer.management.entity.Customer;
import com.customer.management.repository.CustomerRepository;
import com.customer.management.service.ReadRecordService;

@Service
public class ReadRecordServiceImpl implements ReadRecordService {

	@Autowired
	CustomerRepository customerRepository;

	// To get all the Records
	@Override
	public List<Customer> getAllRecords() {
		return customerRepository.findAll();
	}

	// To get all the Records with No Address
	@Override
	public List<Customer> getAllRecordswithNoAddress() {

		Customer customer = new Customer();
		customer.setAddress("");
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("address", ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id", "name");
		Example<Customer> example = Example.of(customer, exampleMatcher);
		return customerRepository.findAll(example);

	}

	// To get all the Records Paged
	@Override
	public Page<Customer> getRecordsPaged() {

		Pageable page = PageRequest.of(0, 3);
		return customerRepository.findAll(page);
	}

	// To get all the Records Pages as per the parameters passed into the methods
	@Override
	public Page<Customer> getRecordsCustomPaged(int pageNo, int noOfRecords) {

		Pageable page = PageRequest.of(pageNo, noOfRecords);
		return customerRepository.findAll(page);

	}

	// To get all the Records sorted as per latest addition to database
	@Override
	public List<Customer> getRecordsLatestAddedOrder() {

		return customerRepository.findAll(Sort.by(Direction.DESC, "id"));

	}

	// To get all the Records Custom Sorted by Id
	@Override
	public List<Customer> getRecordsCustomSortedById(Direction direction) {

		return customerRepository.findAll(Sort.by(direction, "id"));

	}

	// To get all the Records Custom Sorted by Name
	@Override
	public List<Customer> getRecordsCustomSortedByName(Direction direction) {

		return customerRepository.findAll(Sort.by(direction, "name"));
	}

	// To get all the Records Paged , Sorted and Matched with the Provided Name
	@Override
	public Page<Customer> getRecordsSortedPageswithPassedAddressParam(String address) {
		Customer customer = new Customer();
		customer.setAddress(address);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("address", ExampleMatcher.GenericPropertyMatchers.contains())
				.withIgnorePaths("id", "name");
		Example<Customer> example = Example.of(customer, exampleMatcher);
		Pageable page = PageRequest.of(0, 2, Sort.by("name"));
		return customerRepository.findAll(example, page);

	}

	// To get all the Records Custom Paged, Default Sorted by Name and Provided
	// Address Parameters
	@Override
	public Page<Customer> getRecordsCustomPagedSortedbyNamePassedAddressParam(int pageNo, int NoOfRecords,
			String address) {
		Customer customer = new Customer();
		customer.setAddress(address);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("address", ExampleMatcher.GenericPropertyMatchers.contains())
				.withIgnorePaths("id", "name");
		Example<Customer> example = Example.of(customer, exampleMatcher);
		Pageable page = PageRequest.of(pageNo, NoOfRecords, Sort.by("name"));
		return customerRepository.findAll(example, page);

	}

	// To get all the Records Sorted by Name and Matched with Address Parameters
	@Override
	public List<Customer> getRecordsSortedbyNamePassedAddressParam(String address) {
		Customer customer = new Customer();
		customer.setAddress(address);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("address", ExampleMatcher.GenericPropertyMatchers.contains())
				.withIgnorePaths("id", "name");
		Example<Customer> example = Example.of(customer, exampleMatcher);
		return customerRepository.findAll(example, Sort.by("address"));
	}

	// To get all the Records with Provided Ids Parameters
	@Override
	public List<Customer> getRecordsbyIds(List<Integer> ids) {
		return customerRepository.findAllById(ids);
	}

	// To get a Record with provided Id
	@Override
	public Optional<Customer> getRecordbyId(int id) {
		return customerRepository.findById(id);
	}

	// To get a Record with provided Address
	@Override
	public Optional<Customer> getRecordwithPassesParam(String address) {
		Customer customer = new Customer();
		customer.setAddress(address);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("address", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Customer> example = Example.of(customer, exampleMatcher);
		return customerRepository.findOne(example);
	}
}
