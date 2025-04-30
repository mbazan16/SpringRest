package com.proyectoClase.claseRestFull.ln;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoClase.claseRestFull.entities.Departamento;
import com.proyectoClase.claseRestFull.exceptions.CodeError;
import com.proyectoClase.claseRestFull.exceptions.ServicioException;
import com.proyectoClase.claseRestFull.repository.DepartamentoRepository;

@Service
public class AdminDepartamentoImpl implements AdminDepartamento {
	
	Logger log = LoggerFactory.getLogger(AdminDepartamentoImpl.class);
	
	@Autowired
	DepartamentoRepository repository;
	
	
	@Override
	public List<Departamento> listDepartamentos() throws ServicioException{
		log.info("[listDepartamentos]");
		
		List<Departamento> departamentos;
		
		try {
			departamentos= repository.findAll();
			
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return departamentos;
		
	}
	
	
	@Override
	public Departamento conseguirDepartamento(Integer idDepartamento) throws ServicioException{
		log.info("[conseguirDepartamento]");
		log.debug("[idDepartamento: "+idDepartamento+"]");
		
		Departamento departamento;
		
		try {
			Optional<Departamento> departamentoOp= repository.findById(idDepartamento);
			if(!departamentoOp.isPresent()) throw new ServicioException(CodeError.DEPARTAMENTO_NOT_FOUND);
			departamento= departamentoOp.get();
		}catch(ServicioException se) {
			log.error("ServicioException", se);
			throw se;
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return departamento;
		
	}
	
	@Override
	public Departamento grabarDepartamento(Departamento departamento) throws ServicioException{
		log.info("[grabarDepartamento]");
		log.debug("[departamento: "+departamento.toString()+"]");
		
		
		try{
			departamento =repository.save(departamento);
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return departamento;
		
	}
	
	
	@Override
	public void eliminarDepartamento(Integer idDepartamento) throws ServicioException{
		log.info("[eliminarDepartamento]");
		log.debug("[idDepartamento: "+idDepartamento+"]");
		
			try {
			repository.deleteById(idDepartamento);
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		
	}

}
