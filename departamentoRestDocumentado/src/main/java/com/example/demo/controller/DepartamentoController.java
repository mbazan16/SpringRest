package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bussiness.ServicioDepartamento;
import com.example.demo.common.exceptions.ServicioException;
import com.example.demo.entities.Departamento;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	@Autowired
	ServicioDepartamento servicio;
	
	
	@GetMapping
	public List<Departamento> list() throws ServicioException{
		
		return servicio.listDepartamentos();
		
	}
	
	//@GetMapping(value="/{id}",produces = MediaType.APPLICATION_XML_VALUE)	
	@GetMapping(value="/{id}")
	public Departamento find(@PathVariable Integer id) throws ServicioException {
		
		return servicio.conseguirDepartamento(id);
		
	}
	
	
	@PostMapping
	public Departamento create(@RequestBody Departamento departamento) throws ServicioException {
		
		
		return servicio.grabarDepartamento(departamento);
	}
	
	
	@PutMapping
	public Departamento save(@RequestBody Departamento departamento) throws ServicioException {
		
		return servicio.grabarDepartamento(departamento);
	}
	
	
	@DeleteMapping("/{id}")
	public String  delete(@PathVariable Integer id) throws ServicioException {
		
		servicio.eliminarDepartamento(id);
		
		return "Se ha eliminado";
		
	}

}
