package com.cg.farm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.farm.entity.Supplier;
import com.cg.farm.exception.SupplierNotFoundException;
import com.cg.farm.repo.ISupplierRepo;

import java.util.List;
import java.util.Optional;


@Service
public class SupplierServiceImpl implements ISupplierService{


	@Autowired
	ISupplierRepo supplierRepo;
	@Override
	public Supplier addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierRepo.save(supplier);
	}

	@Override
	public Supplier updateSupplier(int id, Supplier supplier) throws SupplierNotFoundException {
		// TODO Auto-generated method stub
		Optional<Supplier> splOpt = supplierRepo.findById(id);
		if (splOpt.isPresent()) {
//			Advertisement adv = advtOpt.get();
		    return supplierRepo.save(supplier);
		}
		else {
			throw new SupplierNotFoundException("Supplier not found with given id: " + id);
		}
	}
	
	@Override
	public Supplier deleteSupplier(int id) throws SupplierNotFoundException {
		// TODO Auto-generated method stub
		Optional<Supplier> splOpt = supplierRepo.findById(id);
		if (splOpt.isPresent()) {
		Supplier spl = splOpt.get();
			supplierRepo.deleteById(id);
			return spl;
		} else {
			throw new SupplierNotFoundException("Supplier not found with given id: " + id);
		}
	

	}


	@Override
	public List<Supplier> getAllFarmer() {
		// TODO Auto-generated method stub
		List<Supplier> suppliers= supplierRepo.findAll();
		return suppliers;
	}

}
