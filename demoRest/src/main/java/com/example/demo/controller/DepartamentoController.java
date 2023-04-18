package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.Departamento;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	List<Departamento> departamentos = new ArrayList<Departamento>();
	
	
	@GetMapping
	public List<Departamento> list(){
		
		return departamentos;
		
	}
	
	//@GetMapping(value="/{id}",produces = MediaType.APPLICATION_XML_VALUE)	
	@GetMapping(value="/{id}")
	public Departamento find(@PathVariable Integer id) {
		
		for(Departamento departamento:departamentos) {
			if(departamento.getId()== id) return departamento;
		}
		return new Departamento(1,"Alguno",1700,100);
		
	}
	
	
	@PostMapping
	public Departamento create(@RequestBody Departamento departamento) {
		
		departamentos.add(departamento);
		return departamento;
	}
	
	
	@PutMapping
	public Departamento save(@RequestBody Departamento departamento) {
		
		for(Departamento departamentoAux:departamentos) {
			if(departamento.getId()== departamentoAux.getId()) {
				departamentoAux.setNombre(departamento.getNombre());
				departamentoAux.setManagerId(departamento.getManagerId());
				departamentoAux.setDireccionId(departamento.getDireccionId());
			}
				
		}
		return departamento;
	}
	
	
	@DeleteMapping("/{id}")
	public String  delete(@PathVariable Integer id) {
		
		for(Departamento departamento:departamentos) {
			if(departamento.getId()== id) departamentos.remove(departamento);
		}
		return "Se ha borrado";
		
	}

}
