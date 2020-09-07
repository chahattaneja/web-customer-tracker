package com.ct.springdemo.service;

import java.util.List;

import com.ct.springdemo.entity.Customer;

public interface CustomerService {
	
	List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(int id);

	void delete(Customer customer);

	List<Customer> searchCustomers(String searchName);

}
