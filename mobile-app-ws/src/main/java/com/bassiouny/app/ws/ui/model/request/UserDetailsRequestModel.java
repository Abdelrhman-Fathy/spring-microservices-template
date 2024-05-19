package com.bassiouny.app.ws.ui.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDetailsRequestModel {
	
	@NotNull(message = "firstName parameter should not be null")
	private String firstName;

	@NotNull(message = "lastName parameter should not be null")
	private String lastName;
	
	@NotNull(message = "email parameter should not be null")
	@Email
	private String email;
	
	@NotNull(message = "password parameter should not be null")
	@Size(min=8, max=16, message = "password should be greather or equal to 8 characters and less thaan or equal 16 charatecters")
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
