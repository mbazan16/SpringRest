package com.example.restfullproyect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.restfullproyect.entities.Person;
import com.example.restfullproyect.repositories.PersonRepository;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(PersonRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Person("Bilbo Baggins", "burglar")));
      log.info("Preloading " + repository.save(new Person("Frodo Baggins", "thief")));
    };
  }
}
