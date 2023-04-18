package com.example.restfullproyect.api.rest;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfullproyect.entities.PersonModel;
import com.example.restfullproyect.repositories.PersonRepository;

@RestController
@RequestMapping("/api/persons2")
class PersonRestFullController2 {



	  private final PersonRepository repository;
	  private final PersonModelAssembler assembler;

	  public PersonRestFullController2(PersonRepository repository, PersonModelAssembler assembler) {
	    this.repository = repository;
	    this.assembler=assembler;
	  }


	 

	  // Single item
	  
	  @GetMapping
	  ResponseEntity<CollectionModel<PersonModel>> list() {
	    
		 
		  return ResponseEntity.ok( //
					assembler.toCollectionModel(repository.findAll()));
		  
	  }

	

}

