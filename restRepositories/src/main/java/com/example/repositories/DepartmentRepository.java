package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Department;


//@RepositoryRestResource(path = "employees", collectionResourceRel = "employees")
public interface DepartmentRepository  extends JpaRepository<Department, Long> {


}
