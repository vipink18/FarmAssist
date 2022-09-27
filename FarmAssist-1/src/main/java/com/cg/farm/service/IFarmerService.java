package com.cg.farm.service;

import java.util.List;

import com.cg.farm.entity.Farmer;
import com.cg.farm.exception.FarmerNotFoundException;

public interface IFarmerService {

	Farmer addFarmer(Farmer farmer);

	Farmer updateFarmer(int Id, Farmer farm) throws FarmerNotFoundException;

	Farmer deleteFarmer(int id) throws FarmerNotFoundException;

	List<Farmer> getAllFarmer();

}
