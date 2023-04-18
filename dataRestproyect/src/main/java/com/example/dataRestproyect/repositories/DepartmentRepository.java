package com.example.dataRestproyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dataRestproyect.entities.Department;


//@RepositoryRestResource(path = "employees", collectionResourceRel = "employees")
public interface DepartmentRepository  extends JpaRepository<Department, Long> {


}
