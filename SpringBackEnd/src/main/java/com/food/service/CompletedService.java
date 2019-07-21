package com.food.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.obj.Completed;
import com.food.repo.CompletedRepo;

@Service
public class CompletedService {
	
	@Autowired
	private CompletedRepo completedRepo;
	
	@Autowired
	private RequestService reqService; 
	
	
	public List<Completed> fetchUserData() {
		List<Completed> all = new ArrayList<>();
		completedRepo.findAll().forEach(all::add);;	
		return all;
	}
	
	public void completedSave(String id,String location,String time) {
		completedRepo.save(new Completed(id,location,time));
	}
	
}
