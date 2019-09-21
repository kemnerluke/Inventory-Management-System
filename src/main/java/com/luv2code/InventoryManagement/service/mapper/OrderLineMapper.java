package com.luv2code.InventoryManagement.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.luv2code.InventoryManagement.dto.OrderLineDTO;
import com.luv2code.InventoryManagement.entity.OrderLine;


@Component
public class OrderLineMapper extends Mapper<OrderLineDTO, OrderLine> {

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public OrderLineDTO mapToDTO(OrderLine e) {
		OrderLineDTO dto = new OrderLineDTO();
		
		dto.setProduct(productMapper.mapToDTO(e.getProduct()));
		dto.setItemName(e.getItemName());
		dto.setLineNumber(e.getLineNumber());
		dto.setOrderLineId(e.getOrderLineId());
		dto.setQuantity(e.getQuantity());
		dto.setTotal(e.getTotal());
		
		
		return dto;
	}

	@Override
	public OrderLine mapToEntity(OrderLineDTO theOrderLine) {
		OrderLine orderLine = new OrderLine();
		/*
		 * orderLine.setProductId(theOrderLine.getItemId());
		 */		orderLine.setItemName(theOrderLine.getItemName());
		orderLine.setLineNumber(theOrderLine.getLineNumber());
		orderLine.setOrderLineId(theOrderLine.getOrderLineId());
		orderLine.setQuantity(theOrderLine.getQuantity());
		orderLine.setTotal(theOrderLine.getTotal());
	
		return orderLine;

	}

}
