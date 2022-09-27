package com.cg.farm.service;

import java.util.List;

import com.cg.farm.entity.Crop;
import com.cg.farm.exception.CropNotFoundException;

public interface ICropService {

	Crop addCrop(Crop C1);

	Crop updateCrop(int cropId, Crop C1) throws CropNotFoundException;

	Crop deleteCrop(int cropId) throws CropNotFoundException; 
	List<Crop> getAllCrop();

}
