package com.crm.web.app.dao;

import java.util.List;

import com.crm.web.app.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();
}