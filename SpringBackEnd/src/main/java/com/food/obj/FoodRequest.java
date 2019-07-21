package com.food.obj;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "foodrequest")
public class FoodRequest {
	
	@Id
	String id;
	int state;
	String location,contno,userid,expiretime,fooddesc,pickuptime;
	String response;
	int amount,volunteerAmount;
	public FoodRequest (String id, String location, String contno, String userid, String foodtype, int amount,String fooddesc, String pickuptime, String response,int state,int volunteerAmount) {
		this.id = id;
		this.location = location;
		this.contno = contno;
		this.userid = userid;
		this.expiretime = foodtype;
		this.amount = amount;
		this.fooddesc = fooddesc;
		this.pickuptime = pickuptime;
		this.response = response;
		this.state = state;
		this.volunteerAmount = volunteerAmount;

	}
	
	
	
	public int getVolunteerAmount() {
		return volunteerAmount;
	}



	public void setVolunteerAmount(int volunteerAmount) {
		this.volunteerAmount = volunteerAmount;
	}



	public String getResponse() {
		return response;
	}



	public void setResponse(String response) {
		this.response = response;
	}



	



	public int getState() {
		return state;
	}



	public void setState(int state) {
		this.state = state;
	}



	public String getExpiretime() {
		return expiretime;
	}



	public void setExpiretime(String expiretime) {
		this.expiretime = expiretime;
	}



	public FoodRequest() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContno() {
		return contno;
	}

	public void setContno(String contno) {
		this.contno = contno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getFooddesc() {
		return fooddesc;
	}

	public void setFooddesc(String fooddesc) {
		this.fooddesc = fooddesc;
	}

	public String getPickuptime() {
		return pickuptime;
	}

	public void setPickuptime(String pickuptime) {
		this.pickuptime = pickuptime;
	}
	
	
	
	
}
