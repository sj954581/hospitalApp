package com.example.hospital.controller;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.example.hospital.model.hospitalModel;
import com.example.hospital.dao.HospitalDao;

@RestController
public class HospitalController {
	
	@Autowired
	public HospitalDao dao;
	
	List<hospitalModel> filtredList = new ArrayList<hospitalModel>();
	
	@RequestMapping(value="/test")
	public String testMethod() {
		return "Hello.. test API for HospitalApp got run";
	}
	
	@PostMapping("/savehospitals")
	public String savehospital(@RequestBody List<hospitalModel> hospitalModels) {
		
		Iterator itr = hospitalModels.iterator();
		while(itr.hasNext()) {
			hospitalModel hm = (hospitalModel) itr.next();
			dao.save(hm);
		}
		
		return "Data Saved... ";
	}
	
	@GetMapping("/getallhospitals")
	public List<hospitalModel> getallhospitals() {
		return (List<hospitalModel>) dao.findAll();
	}
	
	
	@GetMapping("/gethospitalsbycode/{code}")
	public List<hospitalModel> gethospitalsbycode(@PathVariable("code") int code) {
		filtredList.clear();
		List<hospitalModel> list = (List<hospitalModel>) dao.findAll();
		
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			hospitalModel hm = (hospitalModel) itr.next();
			if(hm.getStatecode() == code) {
				filtredList.add(hm);
			}
		}
		return filtredList;
	}
	
	@GetMapping("/gethospitalsbynameandstate")
	public List<hospitalModel> gethospitalsbynameandstate(@RequestParam String name , @RequestParam String state) {
		filtredList.clear();
		List<hospitalModel> list = (List<hospitalModel>) dao.findAll();
		
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			hospitalModel hm = (hospitalModel) itr.next();
			if(hm.getName().equals(name) && hm.getState().equals(state) ) {
				filtredList.add(hm);
			}
		}
		return filtredList;
	}
	
	
	@GetMapping("/gethospitalsbytypeandname")
	public List<hospitalModel> gethospitalsbytypeandname(@RequestParam String type , @RequestParam String name) {
		filtredList.clear();
		List<hospitalModel> list = (List<hospitalModel>) dao.findAll();
		
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			hospitalModel hm = (hospitalModel) itr.next();
			if(hm.getName().equals(name) && hm.getType().equals(type) ) {
				filtredList.add(hm);
			}
		}
		return filtredList;
	}
	
}