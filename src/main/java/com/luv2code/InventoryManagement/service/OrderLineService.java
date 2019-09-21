package com.luv2code.InventoryManagement.service;

import java.util.List;

import com.luv2code.InventoryManagement.dto.OrderLineDTO;

public interface OrderLineService {

	public List<OrderLineDTO> getOrderLines();

	public void saveOrderLine(OrderLineDTO theOrderLine);

	List<OrderLineDTO> getOrderLinesbyOrderHeaderID(int orderHeaderID);
	
	public void deleteOrderLine(int theId);
	
	
}
