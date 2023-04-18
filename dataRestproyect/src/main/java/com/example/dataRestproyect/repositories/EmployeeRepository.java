package com.example.dataRestproyect.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.dataRestproyect.entities.Employee;


@RepositoryRestResource(path = "employees", collectionResourceRel = "employees",exported = false)
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {

	@RestResource(path="names")
    List<Employee> findByName( Integer id);
	
	 @RestResource(path="department")
      List<Employee> findByDepartment_Id(@Param("id") Integer idDepartamento);
}
