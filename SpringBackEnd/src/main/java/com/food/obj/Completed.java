package com.food.obj;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "completed")
public class Completed {
	@Id
	String id;
	
	String location,time;

	public Completed(String id, String location, String time) {
		this.id = id;
		this.location = location;
		this.time = time;
	}
	
	public Completed() {}

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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	
}
