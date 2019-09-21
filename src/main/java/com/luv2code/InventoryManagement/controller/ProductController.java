package com.luv2code.InventoryManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.luv2code.InventoryManagement.dto.ProductDTO;
import com.luv2code.InventoryManagement.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	
	// need to inject the Product dao
	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	public String listProducts(@RequestParam(value = "productId", required = false) Integer theId, Model theModel) {
	 
	    List<ProductDTO> theProducts = productService.getProducts();
	 
	    theModel.addAttribute("products", theProducts);
	 
	    bindProductAttribute(theId, theModel);
	 
	    return "list-products"; 
	    
	    
	}

	private void bindProductAttribute(@RequestParam(value = "productId", required = false) Integer theId, Model theModel) {
	    ProductDTO theProduct = new ProductDTO();
	 
	    if (theId != null) {
	 
	        theProduct = productService.getProducts(theId);
	 
	        System.out.println("Product != null" + theProduct);
	    }
	 
	    theModel.addAttribute("product", theProduct);
	}
	
	

	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") ProductDTO theProduct) {
		
		// save the product using our service
		productService.saveProduct(theProduct);	
		
		return "redirect:/products/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId") int theId,
	                                RedirectAttributes redirectAttributes) {
	 
	    redirectAttributes.addAttribute("productId", theId);
	 
	    return "redirect:/products/list";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("productId") int theId) {
		
		// delete the product
		productService.deleteProduct(theId);
		
		return "redirect:/products/list";
	}

}
