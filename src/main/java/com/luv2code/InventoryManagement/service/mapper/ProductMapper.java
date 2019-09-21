package com.luv2code.InventoryManagement.service.mapper;

import org.springframework.stereotype.Component;

import com.luv2code.InventoryManagement.dto.ProductDTO;
import com.luv2code.InventoryManagement.entity.Product;

@Component
public class ProductMapper extends Mapper<ProductDTO, Product> {

	@Override
	public ProductDTO mapToDTO(Product e) {
		ProductDTO dto = new ProductDTO();
		dto.setName(e.getName());
		dto.setProductId(e.getProductId());
		dto.setColor(e.getColor());
		dto.setPrice(e.getPrice());
		dto.setSku(e.getSku());
		dto.setQty(e.getQty());
		
		
		return dto;
	}

	@Override
	public Product mapToEntity(ProductDTO theProduct) {
		Product product = new Product();

		product.setProductId(theProduct.getProductId());
		product.setName(theProduct.getName());
		product.setColor(theProduct.getColor());
		if (theProduct.getPrice() != null) {
			product.setPrice(theProduct.getPrice());
		}
		if (theProduct.getSku() != null) {
			product.setSku(theProduct.getSku());
		}
		if(theProduct.getQty() !=null) {
			product.setQty(theProduct.getQty());
		}
		
	
		return product;
	}

}
