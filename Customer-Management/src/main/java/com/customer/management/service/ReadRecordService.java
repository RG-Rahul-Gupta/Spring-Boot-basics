package com.customer.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.customer.management.entity.Customer;

public interface ReadRecordService {

	// To get all the Records
	List<Customer> getAllRecords();

	// To get all the Records with No Address
	List<Customer> getAllRecordswithNoAddress();

	// To get all the Records Paged
	Page<Customer> getRecordsPaged();

	// To get all the Records Pages as per the parameters passed into the methods
	Page<Customer> getRecordsCustomPaged(int pageNo, int noOfRecords);

	// To get all the Records sorted as per latest addition to database
	List<Customer> getRecordsLatestAddedOrder();

	// To get all the Records Custom Sorted by Id
	List<Customer> getRecordsCustomSortedById(Direction direction);

	// To get all the Records Custom Sorted by Name
	List<Customer> getRecordsCustomSortedByName(Direction direction);

	// To get all the Records Paged , Sorted and Matched with the Provided Name
	Page<Customer> getRecordsSortedPageswithPassedAddressParam(String address);

	// To get all the Records Custom Paged, Default Sorted by Name and Provided
	// Address Parameters
	Page<Customer> getRecordsCustomPagedSortedbyNamePassedAddressParam(int pageNo, int NoOfRecords, String address);

	// To get all the Records Sorted by Name and Matched with Address Parameters
	List<Customer> getRecordsSortedbyNamePassedAddressParam(String address);

	// To get all the Records with Provided Ids Parameters
	List<Customer> getRecordsbyIds(List<Integer> ids);

	// To get a Record with provided Id
	Optional<Customer> getRecordbyId(int id);

	// To get a Record with provided Address
	Optional<Customer> getRecordwithPassesParam(String address);

}