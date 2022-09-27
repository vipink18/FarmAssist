package com.cg.farm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.farm.entity.Crop;
import com.cg.farm.exception.CropNotFoundException;
import com.cg.farm.repo.ICropRepo;

import java.util.List;
import java.util.Optional;


@Service
public class CropServiceImpl implements ICropService {

	@Autowired
	ICropRepo cropRepo;
	@Override
	public Crop addCrop(Crop C1) {
		// TODO Auto-generated method stub
		return cropRepo.save(C1);
	}

	@Override
	public Crop updateCrop(int CropId, Crop crp) throws CropNotFoundException {
		// TODO Auto-generated method stub
		Optional<Crop> cropOpt = cropRepo.findById(CropId);
		if (cropOpt.isPresent()) {
//			Advertisement adv = advtOpt.get();
		    return cropRepo.save(crp);
		}
		else {
			throw new CropNotFoundException("Crop not found with given id: " + CropId);
		}
	}
	
	@Override
	public Crop deleteCrop(int id) throws CropNotFoundException {
		// TODO Auto-generated method stub
		Optional<Crop> crpOpt = cropRepo.findById(id);
		if (crpOpt.isPresent()) {
		Crop crp = crpOpt.get();
			cropRepo.deleteById(id);
			return crp;
		} else {
			throw new CropNotFoundException("Crop not found with given id: " + id);
		}
	

	}


	@Override
	public List<Crop> getAllCrop() {
		// TODO Auto-generated method stub
		List<Crop> crops= cropRepo.findAll();
		return crops;
	}

}



