package com.example.restfullproyect.api.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfullproyect.entities.Person;
import com.example.restfullproyect.repositories.PersonRepository;

@RestController
@RequestMapping("/api/persons")
class PersonRestFullController {

	private final PersonRepository repository;

	public PersonRestFullController(PersonRepository repository) {
		this.repository = repository;
	}

	/**
	 * Look up all persons, and transform them into a REST collection resource. Then return them through Spring Web's
	 * {@link ResponseEntity} fluent API.
	 */
	@GetMapping
	ResponseEntity<CollectionModel<EntityModel<Person>>> findAll() {

		List<EntityModel<Person>> persons = StreamSupport.stream(repository.findAll().spliterator(), false)
				.map(person -> EntityModel.of(person, //
						Link.of("/api/persons/"+person.getId()), //
						Link.of("/api/persons"))) //
				.collect(Collectors.toList());

		return ResponseEntity.ok( //
				CollectionModel.of(persons, //
						Link.of("/api/persons")));
	}

	@PostMapping
	ResponseEntity<?> newPerson(@RequestBody Person person) {

		try {
			Person savedPerson = repository.save(person);

			EntityModel<Person> personResource = EntityModel.of(savedPerson, //
					Link.of("/persons/"+savedPerson.getId()));

			return ResponseEntity //
					.created(new URI(personResource.getRequiredLink(IanaLinkRelations.SELF).getHref())) //
					.body(personResource);
		} catch (URISyntaxException e) {
			return ResponseEntity.badRequest().body("Unable to create " + person);
		}
	}

	/**
	 * Look up a single {@link Person} and transform it into a REST resource. Then return it through Spring Web's
	 * {@link ResponseEntity} fluent API.
	 *
	 * @param id
	 */
	@GetMapping("/{id}")
	ResponseEntity<EntityModel<Person>> findOne(@PathVariable long id) {

		return repository.findById(id) //
				.map(person -> EntityModel.of(person,  //
						Link.of("/api/persons/"+person.getId()), //
						Link.of("/api/persons"))) //
				.map(ResponseEntity::ok) //
				.orElse(ResponseEntity.notFound().build());
	}

	/**
	 * Update existing person then return a Location header.
	 * 
	 * @param person
	 * @param id
	 * @return
	 */
	@PutMapping("/{id}")
	ResponseEntity<?> updatePerson(@RequestBody Person person, @PathVariable long id) {

		Person personToUpdate = person;
		personToUpdate.setId(id);
		repository.save(personToUpdate);

		Link newlyCreatedLink = Link.of("/api/persons/"+id);

		try {
			return ResponseEntity.noContent().location(new URI(newlyCreatedLink.getHref())).build();
		} catch (URISyntaxException e) {
			return ResponseEntity.badRequest().body("Unable to update " + personToUpdate);
		}
	}

}

