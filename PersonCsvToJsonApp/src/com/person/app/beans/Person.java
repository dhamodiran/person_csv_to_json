package com.person.app.beans;

import com.opencsv.bean.CsvBindByName;

public class Person {
	
	@CsvBindByName(column = "First Name")
	String firstName;
	
	@CsvBindByName(column = "Last Name")
	String lastName;
	
	@CsvBindByName(column = "Age")
	int age;
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
	
	
	
	

}
