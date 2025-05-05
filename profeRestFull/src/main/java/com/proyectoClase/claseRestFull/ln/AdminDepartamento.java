package com.proyectoClase.claseRestFull.ln;

import java.util.List;

import com.proyectoClase.claseRestFull.entities.Departamento;
import com.proyectoClase.claseRestFull.exceptions.ServicioException;



public interface AdminDepartamento {

	List<Departamento> listDepartamentos() throws ServicioException;

	Departamento conseguirDepartamento(Integer idDepartamento) throws ServicioException;

	Departamento grabarDepartamento(Departamento departamento) throws ServicioException;

	void eliminarDepartamento(Integer idDepartamento) throws ServicioException;
	
	

}