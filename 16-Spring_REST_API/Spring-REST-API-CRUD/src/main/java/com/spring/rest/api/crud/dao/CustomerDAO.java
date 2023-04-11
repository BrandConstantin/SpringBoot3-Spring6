package com.spring.rest.api.crud.dao;

import java.util.List;

import com.spring.rest.api.crud.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
