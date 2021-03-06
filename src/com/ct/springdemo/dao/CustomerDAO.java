package com.ct.springdemo.dao;

import java.util.List;

import com.ct.springdemo.entity.Customer;

public interface CustomerDAO {
	
	List<Customer> getCustomers();

	void saveCustomer(Customer customer);
	
	Customer getCustomer(int id);

	void delete(Customer customer);

	List<Customer> searchCustomers(String searchName);

}
