package com.food.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.food.obj.Userdata;
import com.food.repo.ObjectRepository;
import com.food.serviceinterface.ServiceInterface;


@Service
public class UserService implements ServiceInterface {

	
	@Autowired
	private ObjectRepository objRepository;
	
	@Override
	public List<Object> fetchUserData() {
		List<Object> all = new ArrayList<>();
		objRepository.findAll().forEach(all::add);;	
		return all;
	}

	@Override
	public void addOnRepo(Object ob) {
		objRepository.save((Userdata)ob);
		
	}

	@Override
	public Object findSpecificData(String id) {
		List<Userdata> all = new ArrayList<>();
		objRepository.findAll().forEach(all::add);;
		Object data = new Userdata("Null","Null","Null","Null","Null",false,"Null");
		for(int i = 0;i<all.size();i++) {
			if(all.get(i).getId().equals(id)) {
				data = all.get(i);
				break;
			}
			
		}	
		return data;
	}

	public List<Userdata> convert() {
		List<Userdata> alll = new ArrayList<>();
		objRepository.findAll().forEach(alll::add);;	
		return alll;
	}



}
