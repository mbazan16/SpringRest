package com.proyectoClase.claseRestFull.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.proyectoClase.claseRestFull.entities.Departamento;



public interface DepartamentoRepository  extends JpaRepository<Departamento, Integer> {
	
	
    List<Departamento> findByNombre( String nombre);
	
	 
    List<Departamento> findByDireccion_Id(@Param("id") Integer idDireccion);


}
