package com.luv2code.InventoryManagement.service.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.luv2code.InventoryManagement.dto.OrderHeaderDTO;
import com.luv2code.InventoryManagement.dto.OrderLineDTO;
import com.luv2code.InventoryManagement.entity.OrderHeader;
import com.luv2code.InventoryManagement.entity.OrderLine;

@Component
public class OrderHeaderMapper extends Mapper<OrderHeaderDTO, OrderHeader> {

	@Autowired
	private CustomerMapper customerMapper;

	@Autowired
	private ProductMapper productMapper;

	@Override
	public OrderHeaderDTO mapToDTO(OrderHeader e) {
		OrderHeaderDTO dto = new OrderHeaderDTO();
		dto.setOrderHeaderId(e.getOrderHeaderId());
		dto.setNumber(e.getNumber());
		String date = new SimpleDateFormat("yyyy-MM-dd").format(e.getOrderDate());
		dto.setOrderDate(date);
		if (e.getFinalTotal() != null) {
			dto.setFinalTotal(e.getFinalTotal());
		}
		dto.setOrderStatus(e.getOrderStatus());
		dto.setType(e.getType());
		dto.setCustomer(customerMapper.mapToDTO(e.getCustomer()));

		return dto;
	}

	@Override
	public OrderHeader mapToEntity(OrderHeaderDTO theOrderHeader) {
		OrderHeader orderHeader = new OrderHeader();
		orderHeader.setOrderHeaderId(theOrderHeader.getOrderHeaderId());
		orderHeader.setNumber(theOrderHeader.getNumber());
		orderHeader.setOrderStatus(theOrderHeader.getOrderStatus());

		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(theOrderHeader.getOrderDate());
			orderHeader.setOrderDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		orderHeader.setType(theOrderHeader.getType());
		orderHeader.setCustomer(customerMapper.mapToEntity(theOrderHeader.getCustomer()));

		return orderHeader;
	}

}
