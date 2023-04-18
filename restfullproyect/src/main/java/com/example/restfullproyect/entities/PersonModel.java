package com.example.restfullproyect.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.hateoas.RepresentationModel;

public class PersonModel extends RepresentationModel<PersonModel>{

	  private  Long id;
	  private String name;
	  private String role;

	  public PersonModel() {}

	  public PersonModel(String name, String role) {

	    this.name = name;
	    this.role = role;
	  }

	  public Long getId() {
	    return this.id;
	  }

	  public String getName() {
	    return this.name;
	  }

	  public String getRole() {
	    return this.role;
	  }

	  public void setId(Long id) {
	    this.id = id;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public void setRole(String role) {
	    this.role = role;
	  }

}
