package com.cg.farm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import com.cg.farm.entity.Farmer;
import com.cg.farm.exception.FarmerNotFoundException;
import com.cg.farm.service.FarmerServiceImpl;

@RestController

public class FamerController {


	
	@Autowired
	FarmerServiceImpl farmerService;
	

	@GetMapping("/farmer/test")
	ResponseEntity<List<Farmer>> getAllFarmer() {
		List<Farmer> farmers= farmerService.getAllFarmer();
		return new ResponseEntity<>(farmers, HttpStatus.OK); 
	}
	
	@PostMapping("/farmer/add")
	ResponseEntity<Farmer> addFarmer(@RequestBody Farmer frm) {
		Farmer newFrm = farmerService.addFarmer(frm);
		return new ResponseEntity<>(newFrm, HttpStatus.CREATED); 
	}
	
	@DeleteMapping("/farmer/delete/{farmerId}")
	ResponseEntity<Farmer> deleteAdvertisement(@PathVariable("farmerId") int id) throws FarmerNotFoundException{
		Farmer frm = farmerService.deleteFarmer(id);
		return new ResponseEntity<>(frm, HttpStatus.OK);
	}
	
	
	

}
