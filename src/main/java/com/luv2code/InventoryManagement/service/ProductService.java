package com.luv2code.InventoryManagement.service;

import java.util.List;

import com.luv2code.InventoryManagement.dto.ProductDTO;

public interface ProductService {
	
	public List<ProductDTO> getProducts();

	public void saveProduct(ProductDTO theProduct);

	public ProductDTO getProducts(int theId);

	public void deleteProduct(int theId);

}
