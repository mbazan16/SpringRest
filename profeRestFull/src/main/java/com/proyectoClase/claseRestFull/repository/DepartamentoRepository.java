package com.proyectoClase.claseRestFull.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyectoClase.claseRestFull.entities.Departamento;



public interface DepartamentoRepository  extends JpaRepository<Departamento, Integer> {
	
	
    Optional<Departamento> findByNombre(String nombre);
	
	 
   


}
