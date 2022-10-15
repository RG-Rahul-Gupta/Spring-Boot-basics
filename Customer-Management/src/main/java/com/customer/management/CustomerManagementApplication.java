package com.customer.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.customer.management.entity.Customer;
import com.customer.management.service.CheckExistRecordService;
import com.customer.management.service.CountRecordService;
import com.customer.management.service.CreateRecordService;
import com.customer.management.service.DeleteRecordService;
import com.customer.management.service.ReadRecordService;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Slf4j
@ComponentScan(basePackages = {"com.customer.management"})
@EnableSwagger2
public class CustomerManagementApplication implements CommandLineRunner {

	@Autowired
	ReadRecordService readRecordServiceImpl;

	@Autowired
	CreateRecordService createRecordServiceImpl;
	
	@Autowired
	CheckExistRecordService checkExistRecordServiceImpl;
	
	@Autowired
	CountRecordService countRecordServiceImpl;
	
	@Autowired
	DeleteRecordService deleteRecordServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementApplication.class, args);
		System.out.println("This is to proove my point ");
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Practicing of Command Line Runner It executes Before the Main mains Method 2");
		
		//createRecord();
		//countRecord();
		//checkExistRecord();
		//readRecord();
		//deleteRecord();
	}

	private void deleteRecord() {
		log.info("Deleting a Single Record -> {}", deleteRecordServiceImpl.deleteSingleRecord(Customer.builder().id(2).name("Sunny").address("5/123 Jankupuram Lucknow").build()));
	//	log.info("Delete All the Records -> {}", deleteRecordServiceImpl.deleteAllRecords());
		
		List<Integer> ids = new ArrayList();
		ids.add(1);
		ids.add(3);
		ids.add(4);
		List<Customer> listOfCustomers = readRecordServiceImpl.getRecordsbyIds(ids);
		log.info("Delete Multiple Records -> {}", deleteRecordServiceImpl.deleteMultipleRecords(listOfCustomers));
		
	}

	@SuppressWarnings("unused")
	private void checkExistRecord() {
		
		log.info("Check weather a Record Exist By Id -> {}", checkExistRecordServiceImpl.checkExistRecordById(10));
		String address = "Vikas Nagar";
		log.info("Check weather a Record Exist By Parameters -> {}", checkExistRecordServiceImpl.checkExistRecordByParam(address));
		
	}

	@SuppressWarnings("unused")
	private void countRecord() {
		
		log.info("Count No, of Records in the Database -> {}",countRecordServiceImpl.countRecords());
		log.info("Count No, of Records in the Database as per the provided paramaters -> {}",countRecordServiceImpl.countRecordswithParam());
		
	}

	@SuppressWarnings("unused")
	private void createRecord() {
		
		log.info("Add A Record into the DB -> {}", createRecordServiceImpl.addSingleRecord(
				Customer.builder().id(11).name("Rohit").address("4/567 Mahanagar Telephone Exchange Lucknow").build()));
		
		List<Customer> customers = new ArrayList();
		customers.add(Customer.builder().id(12).name("Shiva").address("9/785 Chinnhat Lucknow").build());
		customers.add(Customer.builder().id(13).name("Avantika").address("2-A Vigyanpuri Lucknow").build());
		log.info("Add Multiple Records into the DB -> {}", createRecordServiceImpl.addMultipleRecords(customers));
		
	}

	@SuppressWarnings("unused")
	private void readRecord() {
		List<Customer> customers;

		log.info("Get All the Records of Customer -> {}", readRecordServiceImpl.getAllRecords());
		customers = readRecordServiceImpl.getAllRecords();
		for (Customer customer : customers) {
			System.out.println(customer);
		}

		log.info("Get All the Records of Customer with No Address -> {}",
				readRecordServiceImpl.getAllRecordswithNoAddress());
		customers = readRecordServiceImpl.getAllRecordswithNoAddress();
		for (Customer customer : customers) {
			System.out.println(customer);
		}

		Page<Customer> pages = readRecordServiceImpl.getRecordsPaged();
		List<Customer> listOfCustomers = pages.get().collect(Collectors.toList());
		log.info("Get All the Records of Customer Paged -> {}", listOfCustomers);
		for (Customer customer : listOfCustomers) {
			System.out.println(customer);
		}

		Page<Customer> customPages = readRecordServiceImpl.getRecordsCustomPaged(1, 3);
		List<Customer> listOfCustomers2 = customPages.get().toList();
		log.info("Get All the Records of Customer Customised Paged as per Parameter Passed-> {}", listOfCustomers2);
		for (Customer customer : listOfCustomers2) {
			System.out.println(customer);
		}

		log.info("Get All the Records of Customer in order of Latest Insertion -> {}",
				readRecordServiceImpl.getRecordsLatestAddedOrder());
		customers = readRecordServiceImpl.getRecordsLatestAddedOrder();
		for (Customer customer : customers) {
			System.out.println(customer);
		}

		log.info("Get All the Records of Customer in ascending order by id -> {}",
				readRecordServiceImpl.getRecordsCustomSortedById(Direction.ASC));
		customers = readRecordServiceImpl.getRecordsCustomSortedById(Direction.ASC);
		for (Customer customer : customers) {
			System.out.println(customer);
		}

		log.info("Get All the Records of Customer in descending order by name -> {}",
				readRecordServiceImpl.getRecordsCustomSortedByName(Direction.DESC));
		customers = readRecordServiceImpl.getRecordsCustomSortedByName(Direction.DESC);
		for (Customer customer : customers) {
			System.out.println(customer);
		}

		System.out.println("Please enter the locality you are searching for");
		Scanner sc = new Scanner(System.in);
		String address = sc.nextLine();
		Page<Customer> customPages1 = readRecordServiceImpl.getRecordsSortedPageswithPassedAddressParam(address);
		List<Customer> listOfCustomer3 = customPages1.get().collect(Collectors.toList());
		log.info("Get All the Records of Customer Paged and Sorted having following adrress -> {}", listOfCustomer3);
		customers = listOfCustomer3;
		for (Customer customer : customers) {
			System.out.println(customer);
		}

		Page<Customer> customPages2 = readRecordServiceImpl.getRecordsCustomPagedSortedbyNamePassedAddressParam(1, 3,
				"Nagar");
		List<Customer> listOfCustomer4 = customPages2.get().collect(Collectors.toList());
		log.info("Get All the Records of Customer Custom Paged and Sorted by Name having following adrress -> {}",
				listOfCustomer4);
		customers = listOfCustomer4;
		for (Customer customer : customers) {
			System.out.println(customer);
		}

		String address1 = "Gomti";
		log.info("Get All the Records of Customer Sorted by Name with Passed Address Parameter -> {}",
				readRecordServiceImpl.getRecordsSortedbyNamePassedAddressParam(address1));
		customers = readRecordServiceImpl.getRecordsSortedbyNamePassedAddressParam(address1);
		for (Customer customer : customers) {
			System.out.println(customer);
		}

		List<Integer> ids = new ArrayList();
		ids.add(1);
		ids.add(5);
		ids.add(10);
		log.info("Get All the Records by the Passes ids -> {}", readRecordServiceImpl.getRecordsbyIds(ids));
		customers = readRecordServiceImpl.getRecordsbyIds(ids);
		for (Customer customer : customers) {
			System.out.println(customer);
		}

		int id = 8;
		Optional<Customer> customer = readRecordServiceImpl.getRecordbyId(id);
		if (customer.isPresent()) {
			log.info("Get A Record of the provided Id -> {}", customer.get());
		} else {
			log.info("Couldn't Find a Record with the Following Id");
		}

		String address2 = "3/724 Vikas Nagar Lucknow";
		Optional<Customer> customer2 = readRecordServiceImpl.getRecordwithPassesParam(address2);
		if (customer2.isPresent()) {
			log.info("Get A Record of the Provided Address -> {}", customer2.get());
		} else {
			log.info("Couldn't Find a Record with the Following Id");
		}
        sc.close();
	}
}