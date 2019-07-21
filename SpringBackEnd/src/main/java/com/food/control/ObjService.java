package com.food.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.obj.FoodRequest;
import com.food.obj.FoodRequestRepo;
import com.food.obj.ObjectRepository;
import com.food.obj.Userdata;

@Service
public class ObjService {

	@Autowired
	private ObjectRepository objRepository;
	
	
	
	public List<Userdata> fetchUserdata(){
		List<Userdata> all = new ArrayList<>();
		objRepository.findAll().forEach(all::add);;	
		return all;
	}
	
	public void addOnRepo(Userdata ob) {
		objRepository.save(ob);
	}

	public Userdata findUser(String id) {
		List<Userdata> all = new ArrayList<>();
		objRepository.findAll().forEach(all::add);;
		Userdata data = new Userdata("Null","Null","Null","Null","Null",false,"Null");
		for(int i = 0;i<all.size();i++) {
			if(all.get(i).getId().equals(id)) {
				data = all.get(i);
				break;
			}
			
		}	
		return data;
	}
	
	
	///////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private FoodRequestRepo foodRequestRepo;
	
	
	
	public List<FoodRequest> fetchrequest(){
		List<FoodRequest> req = new ArrayList<>();
		foodRequestRepo.findAll().forEach(req:: add);;	
		return req;
	}
	
	public void addOnFoodRequestRepo(FoodRequest ob) {
		foodRequestRepo.save(ob);
	}

	public FoodRequest findFoodRequest(String id) {
		List<FoodRequest> all = new ArrayList<>();
		foodRequestRepo.findAll().forEach(all::add);;

		FoodRequest data = new FoodRequest("Null","Null","Null","Null","Null",0,"Null","Null","Null","Null",0);
	    data = all.get(0);
		
	    for(int i = 0;i<all.size();i++) {
			if(all.get(i).getId().equals(id)) {
				data = all.get(i);
				break;
			}
			
		}	
		return data;
	}
	
	public void addResponse(FoodRequest f) {
		foodRequestRepo.save(f);
	}
	
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
}
