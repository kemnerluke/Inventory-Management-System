package com.luv2code.InventoryManagement.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.luv2code.InventoryManagement.dto.ProductDTO;

@Entity
@Table(name = "order_header")
public class OrderHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_header_id")
	private int orderHeaderId;

	@Column(name = "number")
	private String number;

	@Column(name = "type")
	private String type;

	@Column(name = "order_date")
	private Date orderDate;
	
	@Column(name="order_status")
	private String orderStatus;
	
	
	
	
	
	


	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cust_id" )
	private Customer customer;

	@OneToMany(mappedBy = "orderHeader", fetch = FetchType.LAZY)
	List<OrderLine> orderLines = new ArrayList<OrderLine>();

	@Column(name="final_total")
	private Integer finalTotal;


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

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	public String getOrderStatus() {
		return orderStatus;
		
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void setFinalTotal(Integer finalTotal) {
		this.finalTotal = finalTotal;
	}

	public Integer getFinalTotal() {
		return this.finalTotal;
	}

	
}
