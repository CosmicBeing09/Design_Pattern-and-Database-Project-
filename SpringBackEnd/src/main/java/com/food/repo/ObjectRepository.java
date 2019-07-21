package com.food.repo;

import org.springframework.data.repository.CrudRepository;

import com.food.obj.Userdata;

public interface ObjectRepository extends CrudRepository<Userdata, String> {

}
