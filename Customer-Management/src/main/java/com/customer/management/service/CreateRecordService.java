package com.customer.management.service;

import java.util.List;

import com.customer.management.entity.Customer;

public interface CreateRecordService {

	String addSingleRecord(Customer customer);

	String addMultipleRecords(List<Customer> customer);

	Customer addSingleRecordwithSaveandFlush(Customer customer);

}