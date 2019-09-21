package com.luv2code.InventoryManagement.dao;

import java.util.List;

import com.luv2code.InventoryManagement.entity.Customer;

public interface CustomerDAO  {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);
	
	public Customer getCustomer(String email);

	public void deleteCustomer(int theId);

}
