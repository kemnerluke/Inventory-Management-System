package com.luv2code.InventoryManagement.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.luv2code.InventoryManagement.entity.Employee;
import com.luv2code.InventoryManagement.entity.OrderHeader;
import com.luv2code.InventoryManagement.service.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data
@Autowired
private EmployeeService employeeService;	
	
// need to inject the customer dao
	
	@GetMapping("/list")
	public String listEmployee(@RequestParam(value = "employeeId", required = false) Integer theId, Model theModel) {
	 
	    List<Employee> theEmployee = employeeService.findAll();
	 
	    theModel.addAttribute("employees", theEmployee);
	 
	    bindEmployeeAttribute(theId, theModel);
	 
	    return "list-employees";
	}

	private void bindEmployeeAttribute(@RequestParam(value = "employeeId", required = false) Integer theId, Model theModel) {
	    Employee theEmployee = new Employee();
	 
	    if (theId != null) {
	 
	        theEmployee = employeeService.findById(theId);
	 
	        System.out.println("Customer != null" + theEmployee);
	    }
	 
	    theModel.addAttribute("employee", theEmployee);
	}
	
	
	@PostMapping("/saveEmployee")
	public String saveEmployees(@ModelAttribute("employee") Employee theEmployee) {
		
		// save the customer using our service
		employeeService.save(theEmployee);	
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
	                                RedirectAttributes redirectAttributes) {
	 
	    redirectAttributes.addAttribute("employeeId", theId);
	 
	    return "redirect:/employees/list";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("employeeId") int theId) {
		
		// delete the customer
		employeeService.deleteById(theId);
		
		return "redirect:/employees/list";
	}
	

	
}




