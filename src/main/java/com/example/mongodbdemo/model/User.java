package com.example.mongodbdemo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
	
	private String name;
	
	private String city;
	
	private long salary;
	
	private String[] hobbies;
		
	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public User(String name, String city, long salary) {
		this.name = name;
		this.city = city;
		this.salary = salary;
	}
	
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", city=" + city + ", salary=" + salary + ", hobbies=" + hobbies + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}
}

