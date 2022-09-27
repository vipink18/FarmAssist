package com.cg.farm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.farm.entity.Farmer;
import com.cg.farm.exception.FarmerNotFoundException;
import com.cg.farm.repo.IFarmerRepo;

import java.util.List;
import java.util.Optional;


@Service

public class FarmerServiceImpl implements IFarmerService{


	@Autowired
	IFarmerRepo farmerRepo;
	@Override
	public Farmer addFarmer(Farmer farmer) {
		// TODO Auto-generated method stub
		return farmerRepo.save(farmer);
	}

	@Override
	public Farmer updateFarmer(int id, Farmer farm) throws FarmerNotFoundException {
		// TODO Auto-generated method stub
		Optional<Farmer> frmOpt = farmerRepo.findById(id);
		if (frmOpt.isPresent()) {
//			Advertisement adv = advtOpt.get();
		    return farmerRepo.save(farm);
		}
		else {
			throw new FarmerNotFoundException("Farmer not found with given id: " + id);
		}
	}
	
	@Override
	public Farmer deleteFarmer(int id) throws FarmerNotFoundException {
		// TODO Auto-generated method stub
		Optional<Farmer> frmOpt = farmerRepo.findById(id);
		if (frmOpt.isPresent()) {
		Farmer frm = frmOpt.get();
			farmerRepo.deleteById(id);
			return frm;
		} else {
			throw new FarmerNotFoundException("Farmer not found with given id: " + id);
		}
	

	}


	@Override
	public List<Farmer> getAllFarmer() {
		// TODO Auto-generated method stub
		List<Farmer> farmers= farmerRepo.findAll();
		return farmers;
	}

}



