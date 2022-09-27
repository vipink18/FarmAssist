package com.cg.farm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.farm.entity.Crop;

public interface ICropRepo extends JpaRepository<Crop,Integer>{
}
