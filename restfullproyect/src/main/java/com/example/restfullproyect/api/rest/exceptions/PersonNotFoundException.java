package com.example.restfullproyect.api.rest.exceptions;

@SuppressWarnings("serial")
public class PersonNotFoundException extends RuntimeException {
	
	public PersonNotFoundException(Long id) {
	    super("Could not find employee " + id);
	  }
	}