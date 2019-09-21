package com.luv2code.InventoryManagement.dto;

import java.util.ArrayList;
import java.util.List;


public class CustomerDTO {
	
	private int id;

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String fullName;

	List<OrderHeaderDTO> orderHeader = new ArrayList<OrderHeaderDTO>();

	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getFirstName() {
		return firstName;
	}





	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}





	public String getLastName() {
		return lastName;
	}





	public void setLastName(String lastName) {
		this.lastName = lastName;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getFullName() {
		return fullName;
	}





	public void setFullName(String fullName) {
		this.fullName = fullName;
	}





	public List<OrderHeaderDTO> getOrderHeader() {
		return orderHeader;
	}





	public void setOrderHeader(List<OrderHeaderDTO> orderHeader) {
		this.orderHeader = orderHeader;
	}

}
