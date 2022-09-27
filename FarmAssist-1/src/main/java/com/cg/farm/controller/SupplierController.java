package com.cg.farm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.farm.entity.Supplier;
import com.cg.farm.exception.SupplierNotFoundException;
import com.cg.farm.service.SupplierServiceImpl;

@RestController
public class SupplierController {


	@Autowired
	SupplierServiceImpl supplierService;
	

	@GetMapping("/supplier/test")
	ResponseEntity<List<Supplier>> getAllSupplier() {
		List<Supplier> suppliers= supplierService.getAllFarmer();
		return new ResponseEntity<>(suppliers, HttpStatus.OK); 
	}
	
	@PostMapping("/supplier/add")
	ResponseEntity<Supplier> addFarmer(@RequestBody Supplier spl) {
		Supplier newSpl = supplierService.addSupplier(spl);
		return new ResponseEntity<>(newSpl, HttpStatus.CREATED); 
	}
	
	@DeleteMapping("/supplier/delete/{supplierId}")
	ResponseEntity<Supplier> deleteSupplier(@PathVariable("supplierId") int id) throws SupplierNotFoundException{
		Supplier spl = supplierService.deleteSupplier(id);
		return new ResponseEntity<>(spl, HttpStatus.OK);
	}
	
	@PutMapping("/supplier/update/{supplierId}")
	ResponseEntity<Supplier> update(@PathVariable("supplierId") int supplierId, @RequestBody Supplier supplier) throws SupplierNotFoundException {
		Supplier updatedsupplier= supplierService.updateSupplier(supplierId, supplier); 
		return new ResponseEntity<>(updatedsupplier, HttpStatus.OK); // 200 Ok
	}
	
	

}

