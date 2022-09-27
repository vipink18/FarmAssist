package com.cg.farm.service;

import java.util.List;

import com.cg.farm.entity.Supplier;
import com.cg.farm.exception.SupplierNotFoundException;

public interface ISupplierService {

	Supplier updateSupplier(int id, Supplier supplier) throws SupplierNotFoundException;

	Supplier addSupplier(Supplier supplier);

	Supplier deleteSupplier(int id) throws SupplierNotFoundException;

	List<Supplier> getAllFarmer();

}
