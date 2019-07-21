package com.food.control;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.food.obj.Completed;
import com.food.obj.FoodRequest;

import com.food.obj.Userdata;
import com.food.service.CompletedService;
import com.food.service.RequestService;
import com.food.service.UserService;
import com.food.serviceinterface.ServiceInterface;

@RestController
public class controlmap {
	
	@Autowired
	private UserService objservice;
	
	
	
	@Autowired
	private RequestService req;
	
	@Autowired
	private CompletedService completedService;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping("/")
	public String hoy() {
		return "Welcome to FoodForAll";
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/all")
	public List<Object> getall(){
		return objservice.fetchUserData();
	}
	
	@RequestMapping("/loginuser/{contno}/{password}")
	public Userdata loginuser(@PathVariable String contno, @PathVariable String password) {
		List<Userdata> ls = objservice.convert();
		Userdata s = new Userdata("Null","Null","Null","Null","Null",true,"Null");
		for(int i = 0;i<ls.size();i++) {
			if(ls.get(i).getContno().trim().equals(contno)) {
				if(ls.get(i).getPassword().trim().equals(password)){
					 s = ls.get(i);
					 break;
				}
			}
		}
		
		return s;
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/reguser")
	public String  postit(@RequestBody Userdata ob) {
		List<Object> ls = objservice.fetchUserData();
		
		String phone = ob.getContno();
		for(int i = 0;i<ls.size();i++) {
			if(((Userdata)ls.get(i)).getContno().equals(phone)) {
				return "Failed";
			}
		}
		objservice.addOnRepo(ob);
		return "Success";
	}
	
	@RequestMapping("/userdata/{id}")
	public Object getUser(@PathVariable String id) {
		return objservice.findSpecificData(id);
	}
	
	
	////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping("/foodrequest")
	public List<Object> getallrequest(){
		return req.fetchUserData();
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/postreq")
	public void  postit(@RequestBody FoodRequest ob) {
		req.addOnRepo(ob);;
	}
	
	
	
	
	
	@RequestMapping("/foodrequest/{id}")
	public Object getRequest(@PathVariable String id) {
		return req.findSpecificData(id);
	}
	
	
	
	@RequestMapping(method=RequestMethod.PUT, value = "/response/{userid}")
	void addreponse(@RequestBody FoodRequest f,@PathVariable String userid) {
		String ss = f.getResponse();
		ss += ","+userid;
		f.setResponse(ss);
		int commas = 0;
		for(int i = 0; i < ss.length(); i++) {
		    if(ss.charAt(i) == ',') commas++;
		}
		if(commas+1 == f.getVolunteerAmount()) {
			f.setState(2);
		}
		req.addResponse(f);
	}
	
	
	
	
	
	@RequestMapping("/myrequest/{userid}")
	public List<FoodRequest> getMyRequest(@PathVariable String userid) {
		List<FoodRequest> ls = new ArrayList<>();
		List<FoodRequest> all = req.convert();
		for(int i = 0;i<all.size();i++) {
			if(all.get(i).getUserid().equals(userid) ) {
				ls.add(all.get(i));
			}
		}
		return ls;
		
	}
	
	@RequestMapping("/myresponse/{userid}")
	public List<FoodRequest> getResponse(@PathVariable String userid) {
		List<FoodRequest> ls = new ArrayList<>();
		List<FoodRequest> all = req.convert();
		for(int i = 0;i<all.size();i++) {
			String s = all.get(i).getResponse();
			int state = all.get(i).getState();
			if(state == 2) {
			StringTokenizer st = new StringTokenizer(s,",");
			 while (st.hasMoreTokens()) {  
		         String ss = st.nextToken();
				 if(ss.equals(userid)) {
		        	 ls.add(all.get(i));
		         }
		     }
			}
		}
		return ls;
		
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	
	@RequestMapping("/completed")
	public List<Completed> getCompleted(){
		return completedService.fetchUserData();
	}
	
	@RequestMapping(method=RequestMethod.PUT,value = "/complete/{id}/{location}/{time}")
	public String completeRequest(@PathVariable String id,String location,String time) {
		FoodRequest temp =  req.convertSpecific(id);
		temp.setState(3);
		req.addResponse(temp);
		completedService.completedSave(id, location, time);
		return "Success";
	}
	@RequestMapping(method=RequestMethod.DELETE,value = "/delete/{id}")
	public void delRequest(@PathVariable String id) {
		req.delete(id);
	}
	
	
	
}
	
	
	
	
	
	
	

