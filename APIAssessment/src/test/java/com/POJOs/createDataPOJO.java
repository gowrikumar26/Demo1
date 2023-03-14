package com.POJOs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class createDataPOJO {
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("salary")
	private String salary;
	
	@JsonProperty("age")
	private String age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}
