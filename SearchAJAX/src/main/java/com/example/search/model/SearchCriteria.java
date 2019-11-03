package com.example.search.model;

import javax.validation.constraints.NotBlank;

public class SearchCriteria {

	@NotBlank(message = "username khong duoc rong!")
	String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
