package com.example.hospital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table(name = "hospital")
public class hospitalModel {
	
	public hospitalModel() {}
	
	public hospitalModel(int pid,String id, String name, int statecode, 
			int districtid, String district, int contact, String addr, String type,String state) {

		this.pid = pid;
		this.id = id; 
		this.name = name; 
		this.statecode = statecode; 
		this.districtid = districtid;
		this.district = district;
		this.contact = contact;
		this.addr = addr;
		this.type = type;
		this.state = state;
	}
	
	@Id
	@GeneratedValue
	public int pid;
	
	@Column(name="id")
	public String id;
	
	@Column(name="state")
	public String state;
	
	@Column(name="name")
	public String name;
	
	@Column(name="statecode")
	public int statecode;
	
	@Column(name="districtid")
	public int districtid;
	
	@Column(name="district")
	public String district;
	
	@Column(name="contact")
	public int contact;
	
	@Column(name="addr")
	public String addr;
	
	@Column(name="type")
	public String type;
	
	
	public int getPid() {
		return pid;
	}
	
	public String getState() {
		return state;
	}
	
	public String getId() {
		return id;
	}
	
	public String getAddr() {
		return addr;
	}
	
	public int getContact() {
		return contact;
	}
	
	public String getDistrict() {
		return district;
	}
	
	public int getDistrictid() {
		return districtid;
	}
	
	public String getName() {
		return name;
	}
	
	public int getStatecode() {
		return statecode;
	}
	
	public String getType() {
		return type;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public void setContact(int contact) {
		this.contact = contact;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public void setDistrictid(int districtid) {
		this.districtid = districtid;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setStatecode(int statecode) {
		this.statecode = statecode;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ id = " + getId() + " name = " + getName() + "adress = " + getAddr() + " ]";
	}
		
}