package com.fisiorctool.dto;

import java.io.Serializable;

public class BasicDataDTO implements Serializable {

	private static final long serialVersionUID = 3012528621609045483L;

	private Integer id;

	private String firstName;

	private String lastName;

	private Integer age;

	private String phone;

	private String job;

	private String gendre;

	private String physicalActivity;

	private Integer daysAWeek;

	private String height;

	private String weight;

	private String email;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getGendre() {
		return gendre;
	}

	public void setGendre(String gendre) {
		this.gendre = gendre;
	}

	public String getPhysicalActivity() {
		return physicalActivity;
	}

	public void setPhysicalActivity(String physicalActivity) {
		this.physicalActivity = physicalActivity;
	}

	public Integer getDaysAWeek() {
		return daysAWeek;
	}

	public void setDaysAWeek(Integer daysAWeek) {
		this.daysAWeek = daysAWeek;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
