package com.ecom.vendor.controller;

import java.util.HashMap;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.vendor.exception.ResourceNotFoundException;
import com.ecom.vendor.model.Vendor;
import com.ecom.vendor.repository.ProductRepository;
import com.ecom.vendor.repository.VendorRepository;
import com.ecom.vendor.service.interfaces.VendorDetails;


@RestController
@RequestMapping("/api/v1/")
public class VendorController {
	
	@Autowired
	private VendorRepository vendorRepository; 
	
	@Autowired
	private VendorDetails vendorDetails;
	
	@CrossOrigin(origins = "http://localhost:4200")	
	@GetMapping("/employees")
	public List<Vendor> getAllEmployees(){
		return vendorRepository.findAll();
	}
	
	//Create employee rest Api
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/employees")
	public Vendor createEmployee(@RequestBody Vendor employee) {
		return vendorRepository.save(employee);
	}
	
	// get employee by id rest api
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/employees/{id}")
	public ResponseEntity<Vendor> getEmployeeById(@PathVariable long id) {
		Vendor employee=vendorRepository.findById(id).
				orElseThrow(()->new ResourceNotFoundException("Vendor not exist with id:"+id));
		System.out.println("================" + employee.toString());
		return ResponseEntity.ok(employee);
	}
	
	// Update employee rest api
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/employees/{id}")
	public ResponseEntity<Vendor> updateEmployee(@PathVariable long id,@RequestBody Vendor employeeDetails){
		Vendor employee=vendorRepository.findById(id).
				orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:"+id));
		
		employee.setVendorname(employeeDetails.getVendorname());
		employee.setRating(employeeDetails.getRating());
		employee.setAddress(employeeDetails.getAddress());
		employee.setContact(employeeDetails.getContact());
		
		Vendor updatedEmployee=vendorRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	// delete employee rest api
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable long id){
		Vendor employee=vendorRepository.findById(id).
				orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:"+id));
		vendorRepository.delete(employee);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	} 
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/vendor")
	public Vendor getVendorByVendorName(@PathVariable String vendorName) {
		return vendorDetails.findVendorByVendorName(vendorName);
	}
}