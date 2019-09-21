package com.luv2code.InventoryManagement.dao;

import java.util.List;

import org.hibernate.Session;

import com.luv2code.InventoryManagement.entity.OrderLine;

public interface OrderLineDAO {
	
	public List<OrderLine> getOrderLines();
	
	public void saveOrderLine(OrderLine theOrderLine);
	
	public List<OrderLine> getOrderLineByOrderHeaderID(int orderHeaderId);

	public void deleteOrderLine(int theId);
}
