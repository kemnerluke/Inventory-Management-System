package com.luv2code.InventoryManagement.dto;

public class OrderHeaderDTO {
	
	
	private int orderHeaderId;

	private String number;

	private String type;

	private String orderDate;
	
	private String orderStatus;
	
	private CustomerDTO customer;
	
	private OrderLineDTO[] orderLine;
	
	private OrderLineDTO newOrderLine;
	
	private int finalTotal;
	
	public int getOrderHeaderId() {
		return orderHeaderId;
	}

	public void setOrderHeaderId(int orderHeaderId) {
		this.orderHeaderId = orderHeaderId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}


	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public OrderLineDTO[] getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(OrderLineDTO[] orderLine) {
		this.orderLine = orderLine;
	}

	public OrderLineDTO getNewOrderLine() {
		return newOrderLine;
	}

	public void setNewOrderLine(OrderLineDTO newOrderLine) {
		this.newOrderLine = newOrderLine;
	}

	public int getFinalTotal() {
		return finalTotal;
	}

	public void setFinalTotal(int finalTotal) {
		this.finalTotal = finalTotal;
	}

}
