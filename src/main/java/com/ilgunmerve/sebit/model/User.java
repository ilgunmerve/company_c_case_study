package com.ilgunmerve.sebit.model;

public class User {

	private int userId;
	private String name;
	private String surname;
	private int salary;
	
	public User() {}
	
	public User(int userId, String name, String surname, int salary) {
		this.userId = userId;
		this.name = name;
		this.surname = surname;
		this.salary = salary;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
