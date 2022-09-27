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
import com.cg.farm.entity.Advertisement;
import com.cg.farm.exception.AdvertisementNotFoundException;
import com.cg.farm.service.AdvertisementServiceImpl;

@RestController

public class AdvertiseController {
	
	@Autowired
	AdvertisementServiceImpl advService;
	

	@GetMapping("/test")
	ResponseEntity<List<Advertisement>> getAllAdvertisement() {
		List<Advertisement> advertisements= advService.getAllAdvertisement();
		return new ResponseEntity<>(advertisements, HttpStatus.OK); // 200 ok
	}
	
	@PostMapping("/adv/add")
	ResponseEntity<Advertisement> addAdvertisement(@RequestBody Advertisement advt) {
		Advertisement newAdvt = advService.addAdvertisement(advt);
		return new ResponseEntity<>(newAdvt, HttpStatus.CREATED); // 201 created 
	}
	
	@DeleteMapping("/adv/delete/{advId}")
	ResponseEntity<Advertisement> deleteAdvertisement(@PathVariable("advId") int advId) throws AdvertisementNotFoundException{
		Advertisement adv = advService.deleteAdvertisement(advId);
		return new ResponseEntity<>(adv, HttpStatus.OK); //200 ok
	}
	
	
	

}
