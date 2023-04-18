package com.example.restfullproyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restfullproyect.entities.Person;

public interface PersonRepository  extends JpaRepository<Person, Long> {


}
