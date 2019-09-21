package com.luv2code.InventoryManagement.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pack")
public class OrderPack {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) ///?????
	@Column(name="pack_id")
	private int packId;
	
	@Column(name ="type")
	private String type;
	
	@Column(name="order_pack_qty")
	private int orderPackQty;
	
	public int getOrderPackQty() {
		return orderPackQty;
	}

	public void setOrderPackQty(int orderPackQty) {
		this.orderPackQty = orderPackQty;
	}

	@Column(name="product_id")
	private int productId;

	public int getPackId() {
		return packId;
	}

	public void setPackId(int packId) {
		this.packId = packId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	

}
