package com.customer.management.service;

import java.util.List;

import com.customer.management.entity.Customer;

public interface DeleteRecordService {

	String deleteSingleRecord(Customer customer);

	String deleteAllRecords();

	String deleteMultipleRecords(List<Customer> customer);

}