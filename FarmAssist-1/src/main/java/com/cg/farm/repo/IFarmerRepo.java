package com.cg.farm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.farm.entity.Farmer;

public interface IFarmerRepo extends JpaRepository<Farmer,Integer>{
}
