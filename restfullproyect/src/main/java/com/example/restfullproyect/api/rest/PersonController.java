package com.example.restfullproyect.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfullproyect.api.rest.exceptions.PersonNotFoundException;
import com.example.restfullproyect.entities.Person;
import com.example.restfullproyect.repositories.PersonRepository;

@RestController
@RequestMapping("/persons")
class PersonController {



	  private final PersonRepository repository;

	  PersonController(PersonRepository repository) {
	    this.repository = repository;
	  }


	  // Aggregate root
	  // tag::get-aggregate-root[]
	  @GetMapping
	  List<Person> all() {
	    return repository.findAll();
	  }
	  // end::get-aggregate-root[]

	  @PostMapping
	  Person newPerson(@RequestBody Person newPerson) {
	    return repository.save(newPerson);
	  }

	  // Single item
	  
	  @GetMapping("/{id}")
	  Person one(@PathVariable Long id) {
	    
	    return repository.findById(id)
	      .orElseThrow(() -> new PersonNotFoundException(id));
	  }

	  @PutMapping("/{id}")
	  Person replacePerson(@RequestBody Person newPerson, @PathVariable Long id) {
	    
	    return repository.findById(id)
	      .map(employee -> {
	        employee.setName(newPerson.getName());
	        employee.setRole(newPerson.getRole());
	        return repository.save(employee);
	      })
	      .orElseGet(() -> {
	        newPerson.setId(id);
	        return repository.save(newPerson);
	      });
	  }

	  @DeleteMapping("/{id}")
	  void deletePerson(@PathVariable Long id) {
	    repository.deleteById(id);
	  }

}

