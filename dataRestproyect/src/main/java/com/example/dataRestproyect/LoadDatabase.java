package com.example.dataRestproyect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.dataRestproyect.entities.Employee;
import com.example.dataRestproyect.repositories.EmployeeRepository;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

 @Bean
  CommandLineRunner initDatabase(EmployeeRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Employee("Employee1", "XXXX")));
      log.info("Preloading " + repository.save(new Employee("Employee2", "XXXX")));
    };
  }
}
