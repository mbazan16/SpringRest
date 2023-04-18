package com.example.hateoas.dto;

import org.springframework.hateoas.RepresentationModel;


public class Employee extends RepresentationModel<Employee> {
	
	private Long id;
	private String name;
	
	
	public Employee() {
		super();
	}
	
	public Employee(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
