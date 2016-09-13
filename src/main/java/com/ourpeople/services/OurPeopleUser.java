package com.ourpeople.services;

import com.ourpeople.dao.UserDao;
import com.ourpeople.models.UserDetails;

public class OurPeopleUser {
	
	@SuppressWarnings("null")
	public UserDetails getUserDetails(String username, String password){
		
		UserDetails userDetails = new UserDetails();
		userDetails =  new UserDao().getUserDetails(username, password);
		
		if(userDetails.getId() != null){
			userDetails.setStatus("SUCCESS");
			userDetails.setText("User Found");
		}else{
			userDetails.setStatus("FAILURE");
			userDetails.setText("User Not Found");
		}
		
		return userDetails;
	}
	
}
