package com.food.obj;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userdata")
public class Userdata {
	private String name,id,location,catagory,password;
	private Boolean admin;
	@Id
	String contno;
	public Userdata(String id,String name,String contno,String location,String catagory,Boolean admin,String password){
		this.id = id;
		this.name = name;
		this.contno = contno;
		this.location = location;
		this.catagory = catagory;
		this.admin = admin;
		this.password = password;
	}
	
	public Userdata(){
		
	}
	
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setContno(String contno) {
		this.contno = contno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContno() {
		return contno;
	}

	public void setCont_no(String contno) {
		this.contno = contno;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	

	
}
