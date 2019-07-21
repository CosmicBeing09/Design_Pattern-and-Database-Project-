package com.food.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.obj.FoodRequest;
import com.food.repo.FoodRequestRepo;
import com.food.serviceinterface.ServiceInterface;

@Service
public class RequestService implements ServiceInterface{
	@Autowired
	private FoodRequestRepo reqRepository;

	@Override
	public List<Object> fetchUserData() {
		List<Object> all = new ArrayList<>();
		reqRepository.findAll().forEach(all::add);;	
		return all;
	}

	@Override
	public void addOnRepo(Object ob) {
		reqRepository.save((FoodRequest)ob);
		
	}

	@Override
	public Object findSpecificData(String id) {
		List<FoodRequest> all = new ArrayList<>();
		reqRepository.findAll().forEach(all::add);;

		FoodRequest data = new FoodRequest("Null","Null","Null","Null","Null",0,"Null","Null","Null",1,0);
	    data = all.get(0);
		
	    for(int i = 0;i<all.size();i++) {
			if(all.get(i).getId().equals(id)) {
				data = all.get(i);
				break;
			}
			
		}	
		return data;
	}
	
	
	
	public List<FoodRequest> convert(){
		List<FoodRequest> all = new ArrayList<>();
		reqRepository.findAll().forEach(all::add);;	
		return all;
	}
	
	
	public void addResponse(FoodRequest f) {
		reqRepository.save(f);
	}
	
	public FoodRequest convertSpecific(String id) {
		List<FoodRequest> all = new ArrayList<>();
		reqRepository.findAll().forEach(all::add);;

		FoodRequest data = new FoodRequest("Null","Null","Null","Null","Null",0,"Null","Null","Null",1,0);
	    data = all.get(0);
		
	    for(int i = 0;i<all.size();i++) {
			if(all.get(i).getId().equals(id)) {
				data = all.get(i);
				break;
			}
			
		}	
		return data;

	}
	
	public void delete(String id) {
		List<FoodRequest> all = new ArrayList<>();
		reqRepository.findAll().forEach(all::add);;
		FoodRequest data = new FoodRequest("Null","Null","Null","Null","Null",0,"Null","Null","Null",1,0);
	    data = all.get(0);
		
	    for(int i = 0;i<all.size();i++) {
			if(all.get(i).getId().equals(id)) {
				data = all.get(i);
				break;
			}
			
		}
	    
	    reqRepository.delete(data);
	}
	

}
