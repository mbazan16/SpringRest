package com.example.restfullproyect.api.rest;


import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.example.restfullproyect.entities.Person;
import com.example.restfullproyect.entities.PersonModel;

@Component
public class PersonModelAssembler extends RepresentationModelAssemblerSupport<Person, PersonModel>{ 

     public PersonModelAssembler() {
		super(Person.class,PersonModel.class);
	}

	
	@Override
	public PersonModel toModel(Person entity) {
		PersonModel personModel = instantiateModel(entity);	     
		
		personModel.setId(entity.getId());
		personModel.setName(entity.getName());
		personModel.setRole(entity.getRole());
		
		personModel.add(Link.of("/api/person2/"+entity.getId()));
		return personModel;
	}


	@Override
	public CollectionModel<PersonModel> toCollectionModel(Iterable<? extends Person> entities) {
		
		return super.toCollectionModel(entities);
	}
}
