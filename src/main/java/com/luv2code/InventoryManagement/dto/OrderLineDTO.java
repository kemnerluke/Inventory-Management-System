package com.luv2code.InventoryManagement.dto;

public class OrderLineDTO {

	private int orderLineId;

	private String lineNumber;

	private ProductDTO product;

	private int quantity;
	
	private int total;
	
	private String itemName;
	
	private int price;
	
	private int finalTotal;
	
	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	
	
	public int getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(int orderLineId) {
		this.orderLineId = orderLineId;
	}

	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int orderPackQuantity) {
		this.quantity = orderPackQuantity;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getFinalTotal() {
		return finalTotal;
	}

	public void setFinalTotal(int finalTotal) {
		this.finalTotal = finalTotal;
	}


}
