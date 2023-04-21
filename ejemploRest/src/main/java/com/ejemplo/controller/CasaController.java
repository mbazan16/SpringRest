package com.ejemplo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.entities.Casa;
import com.ejemplo.repositories.CasaRepository;

@RestController
@RequestMapping("/casa")
@CrossOrigin(origins = "*")
public class CasaController {
	Logger log = LoggerFactory.getLogger(CasaController.class);
	
	@Autowired
	CasaRepository repositorio;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Casa> listCasas(){
		List<Casa> casas = new ArrayList<Casa>();
		
		casas=repositorio.findAll();
		return casas;
		
	}
	
	
	
	@PostMapping
	public void newCasa(@RequestBody Casa casa){
		
		
		repositorio.save(casa);
		
	}
	
	/* Metodo de ejemplo para comunicacion con ajax no sería de ninguna forma necesario*/
	@PostMapping(value = "/new",
	        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public void newCasaJQuery(Casa casa){
		
		
		repositorio.save(casa);
		
	}
	
	
	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Casa viewCasa(@PathVariable Long id){
		
		return repositorio.findById(id).get();
		
	}
	
	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public Casa modifyCasa(@RequestBody Casa casa){
		
		
		repositorio.save(casa);
		return repositorio.getById(casa.getId());
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteCasa(@PathVariable Long id){	
		
		repositorio.deleteById(id);
		
	}

}
