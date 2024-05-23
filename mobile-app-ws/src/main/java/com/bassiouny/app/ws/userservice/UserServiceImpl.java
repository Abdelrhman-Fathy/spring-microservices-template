package com.bassiouny.app.ws.userservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bassiouny.app.ws.shared.Utils;
import com.bassiouny.app.ws.ui.model.request.UserDetailsRequestModel;
import com.bassiouny.app.ws.ui.model.response.UserRest;


@Service
public class UserServiceImpl implements UserService{
	

	Map<String, UserRest> users;
	
	Utils utils;
	
	@Autowired
	public UserServiceImpl(Utils utils){
		this.utils = utils;
	}
	
	@Override
	public UserRest createUser(UserDetailsRequestModel userReq) 
	{
		UserRest user = new UserRest();
		user.setEmail(userReq.getEmail());
		user.setFirstName(userReq.getFirstName());
		user.setLastName(userReq.getLastName());
		String userId = utils.generateUserId();
		user.setUserID(userId);
		if(users == null) users = new HashMap<>();
		users.put(userId, user);
		return user;
	}

}
