package com.food.serviceinterface;

import java.util.List;







public interface ServiceInterface {
	public List<Object> fetchUserData();
	public void addOnRepo(Object ob);
	public Object findSpecificData(String id);
}
