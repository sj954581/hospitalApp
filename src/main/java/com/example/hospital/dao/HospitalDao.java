package com.example.hospital.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.hospital.model.hospitalModel;

public interface HospitalDao extends CrudRepository<hospitalModel, Integer>{
	

}