package com.bassiouny.app.ws.userservice;

import com.bassiouny.app.ws.ui.model.request.UserDetailsRequestModel;
import com.bassiouny.app.ws.ui.model.response.UserRest;

public interface UserService {
	public UserRest createUser(UserDetailsRequestModel userReq);
}
