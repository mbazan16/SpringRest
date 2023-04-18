package com.example.demo.bussiness;

import java.util.List;

import com.example.demo.common.exceptions.ServicioException;
import com.example.demo.entities.Departamento;

public interface ServicioDepartamento {

	List<Departamento> listDepartamentos() throws ServicioException;

	Departamento conseguirDepartamento(Integer idDepartamento) throws ServicioException;

	Departamento grabarDepartamento(Departamento departamento) throws ServicioException;

	void eliminarDepartamento(Integer idDepartamento) throws ServicioException;

}