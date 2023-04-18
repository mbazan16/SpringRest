package com.example.hateoas.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hateoas.dto.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@GetMapping
	public @ResponseBody ResponseEntity<?> listadoBasico() {

		List<Employee> employees = new ArrayList<Employee>();

		Employee employee = new Employee(1l, "Empleado");

		employee.add(linkTo(methodOn(EmployeeController.class).ver(employee.getId())).withSelfRel());

		employees.add(employee);

		Link link = linkTo(methodOn(EmployeeController.class).listadoBasico()).withSelfRel();
		CollectionModel<Employee> resources = CollectionModel.of(employees, link);
		return ResponseEntity.ok(resources);

	}

	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Employee> ver(@PathVariable Long id) {

		Employee employee = new Employee(id, "Empleado");

		employee.add(linkTo(methodOn(EmployeeController.class).ver(employee.getId())).withSelfRel());
		employee.add(linkTo(methodOn(EmployeeController.class).listadoBasico()).withSelfRel());

		return ResponseEntity.ok(employee);

	}

}
