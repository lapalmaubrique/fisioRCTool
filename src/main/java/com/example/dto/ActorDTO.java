package com.example.dto;

import java.io.Serializable;

public class ActorDTO implements Serializable {

	private static final long serialVersionUID = 3012528621609045483L;

	private Integer id;

	private String firstName;

	private String lastName;

	private String lastUpdateString;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getLastUpdateString() {
		return lastUpdateString;
	}

	public void setLastUpdateString(String lastUpdateString) {
		this.lastUpdateString = lastUpdateString;
	}

}
