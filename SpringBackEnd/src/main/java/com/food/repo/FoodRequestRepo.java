package com.food.repo;


import org.springframework.data.repository.CrudRepository;

import com.food.obj.FoodRequest;

public interface FoodRequestRepo extends CrudRepository<FoodRequest, String>{
	
}
